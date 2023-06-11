package DocuMin.controllers;

import DocuMin.entities.*;

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

    /* OPERAÇÕES PARA DOCUMENTO */

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

    /* OPERAÇÕES PARA ELEMENTO */

    public int criaElemento(String tituloDoc, Elemento elem) {
        return documentos.get(tituloDoc).criaElemento(elem);
    }

    public boolean apagarElemento(String tituloDoc, int posElemento) {
        return documentos.get(tituloDoc).apagarElemento(posElemento);
    }

    public int contarElementos(String titulo) {
        if (titulo.trim().equals("")) throw new IllegalArgumentException();
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();

        return documentos.get(titulo).getElementos().size();
    }

    public String[] exibirDocumento(String titulo) {
        if (titulo.trim().equals("")) throw new IllegalArgumentException();
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();

        return documentos.get(titulo).exibeDocumento();
    }

    private boolean estaCadastrado(String titulo) {
        return documentos.get(titulo) != null;
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

        if (!(docAtalho.isAtalho() || docRef.hasAtalho())) {
            docRef.setHasAtalho(true);
            docAtalho.setIsAtalho(true);

            return documentos.get(tituloDoc)
                    .criaElemento(new Atalho(tituloReferenciado, docRef.mediaPrioridade(), docRef));
        } else {
            throw new IllegalStateException();
        }
    }

    /* OPERAÇÕES PARA VISÃO */

    public int criarVisaoCompleta(String tituloDoc) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();

        Visao visao = new VisaoCompleta(documentos.get(tituloDoc));
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    public int criarVisaoResumida(String tituloDoc) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();

        Visao visao = new VisaoResumida(documentos.get(tituloDoc));
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();
        if (prioridade < 1 || prioridade > 5) throw new IllegalArgumentException();

        Visao visao = new VisaoPrioritaria(documentos.get(tituloDoc), prioridade);
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    public int criarVisaoTitulo(String tituloDoc) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();

        VisaoTitulo visao = new VisaoTitulo(documentos.get(tituloDoc));
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    public String[] exibirVisao(int visaoId) {
        return visoes.get(visaoId).exibirVisao();
    }
}
