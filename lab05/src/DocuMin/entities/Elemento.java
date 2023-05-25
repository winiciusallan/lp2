package DocuMin.entities;

import java.util.HashMap;

public abstract class Elemento {

    /* COLOCAR METODOS ABSTRATOS */
    
    protected int prioridade;
    protected String valor;
    private HashMap<String, String> propriedades;

    public Elemento(String valor, int prioridade) {
        this.prioridade = prioridade;
        this.propriedades = new HashMap<>();
    }

    public int getPrioridade() { return prioridade; }

    public String getValor() { return valor; }

    public HashMap<String, String> getPropriedades() { return propriedades; }

}
