package DocuMin;

import DocuMin.controllers.DocumentoController;
import DocuMin.entities.*;

public class DocuminFacade {

    private DocumentoController documentoController;

    /* OPERAÇÕES PARA DOCUMENTO */

    public DocuminFacade() {
        this.documentoController = new DocumentoController();
    }

    public boolean criarDocumento(String titulo) throws IllegalAccessException {
        return this.documentoController.criarDocumento(titulo);
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) throws IllegalAccessException {
        return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
    }

    public void removerDocumento(String titulo) {
        this.documentoController.removerDocumento(titulo);
    }

    public int contarElementos(String titulo) {
        return this.documentoController.contarElementos(titulo);
    }

    public String[] exibirDocumento(String titulo) {
        return this.documentoController.exibirDocumento(titulo);
    }

    /* OPERAÇÕES PARA ELEMENTOS */

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return documentoController.criaElemento(tituloDoc, new Texto(valor, prioridade));
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return documentoController.criaElemento(tituloDoc, new Titulo(valor, prioridade, nivel, linkavel));
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return documentoController.criaElemento(tituloDoc, new Lista(valorLista, prioridade, separador, charLista));
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return documentoController.criaElemento(tituloDoc, new Termo(valorTermos, prioridade, separador, ordem));
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return "";
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return "";
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return false;
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {

    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {

    }
}
