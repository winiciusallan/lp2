package DocuMin;

import java.util.HashMap;

public class DocumentoController {

    private HashMap<String, Documento> documentos;

    public DocumentoController() {
        this.documentos = new HashMap<>();
    }

    public boolean criarDocumento(String titulo) {
        if (estaCadastrado(titulo)) return false;

        if (titulo.length() <= 0) {
            throw new IllegalAccessException("Título com tamanho inválido");
        }

        documentos.put(titulo, new Documento(titulo));
        return true;
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        if (estaCadastrado(titulo)) return false;

        if (titulo.length() <= 0) {
            throw new IllegalAccessException("Título com tamanho inválido");
        }

        documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
        return true;
    }

    public void removerDocumento(String titulo) {
        documentos.remove(titulo);
    }

    public int contarElementos(String titulo) {
        // To be implemented
        return 0;
    }

    private boolean estaCadastrado(String titulo) {
        return documentos.get(titulo) != null;
    }
}
