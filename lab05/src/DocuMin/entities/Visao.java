package DocuMin.entities;

public abstract class Visao {

    protected Documento doc;

    public Visao(Documento doc) {
        this.doc = doc;
    }

    abstract String[] exibirVisao();
}
