package DocuMin.entities;

import DocuMin.interfaces.ElemInterface;

import java.util.HashMap;

/**
 * Representação de um elemento. Um elemento pode ser de vários tipos, tendo um valor, prioridade e um conjunto de
 * propriedades.
 *
 * @author Winicius Allan - 122110397
 */
public abstract class Elemento implements ElemInterface {

    /* COLOCAR METODOS ABSTRATOS */

    /**
     * A prioridade do elemento.
     */
    protected int prioridade;
    /**
     * O valor do elemento.
     */
    protected String valor;

    /**
     * Um mapa contendo as propriedades do elemento. O identificador é uma string.
     */
    private HashMap<String, String> propriedades;

    /**
     * Construtor do elemento
     *
     * @param valor      O valor do elemento
     * @param prioridade A propriedade do elemento.
     */
    public Elemento(String valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
        this.propriedades = new HashMap<>();
    }

    public int getPrioridade() { return prioridade; }

    public String getValor() { return valor; }

    public HashMap<String, String> getPropriedades() { return propriedades; }

}
