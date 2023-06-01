package org.MeuDesafioMinhaVida;

import java.util.HashMap;

public class Desafio {

    private String titulo;
    private int vezesExecutado;
    private HashMap<Integer, Acao> acoes;

    public Desafio(String titulo) {
        this.titulo = titulo;
        this.vezesExecutado = 0;
        this.acoes = new HashMap<>();
    }
    public String getTitulo() { return titulo; }

    public HashMap<Integer, Acao> getAcoes() { return acoes; }

    public Acao getAcao(int id) { return acoes.get(id); }
    public void addAcao(int id, Acao acao) {
        acoes.put(id, acao);
    }


}
