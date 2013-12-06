package dados;

/**
 *
 * @author cachutti
 */

//Representação de um relato de evento. Atributos da classe RelatoEvento:
public class RelatoEvento {

    public TipoRelatoEventoEnum idTipo; //Indicador do tipo do relato de evento.
    public int[] info; //Informação associada ao relato de evento.
    public int timestamp; //Tempo do sistema quando da geração do relato de evento    

    public RelatoEvento(TipoRelatoEventoEnum idTipo, int[] info, int timestamp) {
        this.idTipo = idTipo;
        this.info = info;
        this.timestamp = timestamp;
    }

    public TipoRelatoEventoEnum getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TipoRelatoEventoEnum idTipo) {
        this.idTipo = idTipo;
    }

    public int[] getInfo() {
        return info;
    }

    public void setInfo(int[] info) {
        this.info = info;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }


}
