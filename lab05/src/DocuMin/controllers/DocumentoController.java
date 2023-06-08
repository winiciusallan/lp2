package DocuMin.controllers;

import DocuMin.entities.Atalho;
import DocuMin.entities.Documento;
import DocuMin.entities.Elemento;
import DocuMin.entities.Visao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoController {

    private HashMap<String, Documento> documentos;
    private ArrayList<Visao> visoes;

    public DocumentoController() {
        this.documentos = new HashMap<>();
        this.visoes = new ArrayList<>();
    }

    /* OPERAÇÕES PARA ELEMENTO */

    public boolean criarDocumento(String titulo) throws IllegalAccessException {
        if (estaCadastrado(titulo)) return false;

        if (titulo.trim().equals("")) {
            throw new IllegalAccessException("Título com tamanho inválido");
        }

        documentos.put(titulo, new Documento(titulo));
        return true;
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) throws IllegalAccessException {
        if (estaCadastrado(titulo)) return false;

        if (titulo.trim().equals("")) {
            throw new IllegalAccessException("Título com tamanho inválido");
        }
        if (tamanhoMaximo <= 0) { throw new IllegalArgumentException(); }

        documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
        return true;
    }

    public void removerDocumento(String titulo) {
        if (titulo.trim().equals("")) throw new IllegalArgumentException();
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();

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

    /* OPEAÇÕES PARA ELEMENTO */

    public int criaElemento(String tituloDoc, Elemento elem) {
        return documentos.get(tituloDoc).criaElemento(elem);
    }

    public boolean apagarElemento(String tituloDoc, int posElemento) {
        return documentos.get(tituloDoc).apagarElemento(posElemento);
    }

    public void moverParaCima(String tituloDoc, int posElemento) {
        documentos.get(tituloDoc).moverPosicaoAcima(posElemento);
    }

    public void moverParaBaixo(String tituloDoc, int posElemento) {
        documentos.get(tituloDoc).moverPosicaoAbaixo(posElemento);
    }

    public String representacaoCompleta(String tituloDoc, int posElemento) {
        return documentos.get(tituloDoc).getElemento(posElemento).representacaoCompleta();
    }

    public String representacaoResumida(String tituloDoc, int posElemento) {
        return documentos.get(tituloDoc).getElemento(posElemento).representacaoResumida();
    }

    public int criarAtalho(String tituloDoc, String tituloReferenciado) {
        Documento docRef = documentos.get(tituloReferenciado);
        Documento docAtalho = documentos.get(tituloDoc);

        if (!(docAtalho.isAtalho() || docAtalho.hasAtalho())) {
            return documentos.get(tituloDoc)
                    .criaElemento(new Atalho(tituloReferenciado, docRef.mediaPrioridade(), docRef));
        } else {
            throw new IllegalStateException();
        }
    }

}
