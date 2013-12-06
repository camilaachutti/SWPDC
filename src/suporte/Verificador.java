package suporte;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author cachutti
 */

public class Verificador {
    private static String caminhoAbsoluto = System.getProperty("user.dir") + "/src/arquivos/";
    private static Verificador instancia = null;
    
    BufferedReader bufReaderSysInfo = null, bufReaderRegistroTemp = null;
    Comunicador comunicador;
  
    public static Verificador instanciar(){
        if (instancia == null) {
            instancia = new Verificador();
        }
      return instancia;
    }

    private Verificador() {
        this(new BufferedReader(openFile("registroTemp.txt")), new BufferedReader(openFile("sysInfo.txt")), Comunicador.instanciar());
    }
        
    protected Verificador(BufferedReader bufReaderRegistroTemp, BufferedReader bufReaderSysInfo, Comunicador comunicador) {
        this.bufReaderRegistroTemp = bufReaderRegistroTemp;        
        this.bufReaderSysInfo = bufReaderSysInfo;
        this.comunicador = comunicador;
       }
    
    private static FileReader openFile(String fileName) {
        try {
            return new FileReader(caminhoAbsoluto + fileName);
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean verificaStatusAlimentacaoLigado() {    
        String linha = readSysInfoLine();

        return linha != null && linha.equals("[status] ligado");
    }
    
    public String verificaEstado() {
        String estado = null;
        String linha = readSysInfoLine();
        
        if (linha != null && linha.contains("[modoOp]")) {
            estado = linha.substring(9);
        } else {  
            guardarNoHistorico("Problema com o o arquivo de sistema do PDC");
        }
        return estado;
    }
    
    private String readSysInfoLine() {
        String line = null;
        try {    
            line = bufReaderSysInfo.readLine();
        } catch (IOException ex) {
     }   
        return line;
    }
    
    // TODO: caso onde munAmostrasAtual tem 2 dígitos
    public float[] obterAmostras(int numAmostraAtual) {
        float[] amostras = null;
        String linha = readRegistroTempLine();

        if (linha == null || !linha.contains("[numAm]")) {
            guardarNoHistorico("Problema no arquivo de amostras");
        } else if (EhAmostraAtual(numAmostraAtual, linha)) {
            amostras = organizarAmostrar(linha);
            guardarNoHistorico("Amostras obtidas com sucesso");
        } else {
            guardarNoHistorico("Arquivo de amostras desatualizado");
        } 
        return amostras;
        
    }

    private String readRegistroTempLine() {
        String line = null;
        try {    
            line = bufReaderRegistroTemp.readLine();
        } catch (IOException ex) {
        }   
        return line;
    }

    private float[] organizarAmostrar(String amostras) {
        float[] temperaturas;
        String valores;

        temperaturas = new float[12];
        valores = amostras.substring(18);

        for (int i = 0, j = 0; i < 12; i++, j +=6) {
            if (!valores.substring(j, j+1).equals("-")) {
                temperaturas[i] = Float.parseFloat(valores.substring(j, j+4 ));
            } else {
                temperaturas[i] = Float.parseFloat(valores.substring(j, j+5 ));
                j++;
            }
        } 
        return temperaturas;
    }

    private boolean EhAmostraAtual(int numAmostraAtual, String linha) {
        return numAmostraAtual == Float.parseFloat(linha.substring(8, 9));
    }

    private void guardarNoHistorico(String mensagem) {
        comunicador.guardarNoHistorico(mensagem);
    }

}
