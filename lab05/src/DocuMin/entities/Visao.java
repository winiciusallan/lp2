package DocuMin.entities;

import DocuMin.interfaces.visaoInterface;

/**
 * Representação de visão. Uma visão nada mais é do que um tipo de exportação do documento. Podendo ter a representação
 * de todos os elementos do documento ou de apenas alguns deles.
 *
 * @author Winicius Allan - 122110397
 */
public abstract class Visao implements visaoInterface {

    /**
     * O documento referenciado pelo atalho.
     */
    protected Documento docReferenciado;

    /**
     * Construtor de visão.
     *
     * @param docReferenciado O documento referenciado.
     */
    public Visao(Documento docReferenciado) {
        this.docReferenciado = docReferenciado;
    }

}
