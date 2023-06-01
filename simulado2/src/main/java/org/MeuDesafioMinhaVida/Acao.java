package org.MeuDesafioMinhaVida;

public class Acao {

    private int id;
    private String data;
    private int progresso;

    public Acao(int id, String data) {
        this.data = data;
        this.progresso = 0;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public int getProgresso() {
        return progresso;
    }

    public void atualizaProgresso() {
        if (progresso >= 100) { return; }
        progresso += 10;
    }

    public void atualizaProgresso(int progresso) {
        if (progresso >= 100) { return; }
        this.progresso += progresso;
    }


}
