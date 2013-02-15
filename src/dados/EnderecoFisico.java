/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author cachutti
 */
//Um endereço virtual é um inteiro de 32bits que pode ser interpretado de forma
// linear ou divido em dois endereços: página e deslocamento (offset)
//dentro da página.

public class EnderecoFisico {
     public long end32bit; //Interpretação de um endereço virtual como um inteiro de 32 bits.
     public Endereco endereco;//Interpretação de um endereço virtual separado em
                                //página (MSB e LSB) e endereço
                                //(deslocamento) dentro da página.
}
