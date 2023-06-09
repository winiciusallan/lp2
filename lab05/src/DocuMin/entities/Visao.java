package DocuMin.entities;

import DocuMin.interfaces.visaoInterface;

public abstract class Visao implements visaoInterface {

    protected Documento docReferenciado;

    public Visao(Documento docReferenciado) {
        this.docReferenciado = docReferenciado;
    }

    //    abstract String[] exibirVisao();
}
