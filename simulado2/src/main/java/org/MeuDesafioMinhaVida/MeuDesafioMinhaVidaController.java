package org.MeuDesafioMinhaVida;

import java.util.ArrayList;
import java.util.HashMap;

public class MeuDesafioMinhaVidaController {

    private ArrayList<Desafio> desafios;

    public MeuDesafioMinhaVidaController() {
        this.desafios = new ArrayList<>();
    }

    public ArrayList<Desafio> getDesafios() { return desafios; }

    public boolean addDesafio(String titulo) {
        if (jaExisteDesafio(titulo)) return false;
        desafios.add(new Desafio(titulo));
        return true;
    }

    public boolean addAcao(int index, String data, int id) {
        desafios.get(index).addAcao(id, new Acao(id, data));
        return true;
    }

    public void atualizaProgressoAcao(int id) {
        for (Desafio desafio : desafios) {
            // To be implemented
        }
    }
    private boolean jaExisteDesafio(String titulo) {
        for (Desafio desafio : desafios) {
            if (desafio == null) { return false; }
            if (desafio.getTitulo().equals(titulo)) { return true; }
        }
        return false;
    }
}
