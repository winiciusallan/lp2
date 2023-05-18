package DocuMin;

public class Facade {

    private DocumentoController documentoController;

    public Facade() {
        this.documentoController = new DocumentoController();
    }

    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
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
}
