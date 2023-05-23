package DocuMin.controllers;

import DocuMin.entities.Documento;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoController {

    private HashMap<String, Documento> documentos;

    public DocumentoController() {
        this.documentos = new HashMap<>();
    }

    public boolean criarDocumento(String titulo) {
        if (estaCadastrado(titulo)) return false;

        if (titulo.length() <= 0 || titulo.trim().equals("")) {
            // throw new IllegalAccessException("Título com tamanho inválido");
        }

        documentos.put(titulo, new Documento(titulo));
        return true;
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if (estaCadastrado(titulo)) return false;

        if (titulo.length() <= 0 || titulo.trim().equals("")) {
            // throw new IllegalAccessException("Título com tamanho inválido");
        }

        documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
        return true;
    }

    public void removerDocumento(String titulo) {
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();
        if (titulo.trim().equals("")) throw new IllegalArgumentException();

        documentos.remove(titulo);
    }

    public int contarElementos(String titulo) {
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();
        if (titulo.trim().equals("")) throw new IllegalArgumentException();

        return documentos.get(titulo).getElementos().size();
    }

    public String[] exibirDocumento(String titulo) {
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();
        if (titulo.trim().equals("")) throw new IllegalArgumentException();

        return documentos.get(titulo).exibeDocumento();
    }

    private boolean estaCadastrado(String titulo) {
        return documentos.get(titulo) != null;
    }
}
