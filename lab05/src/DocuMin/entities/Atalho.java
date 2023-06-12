package DocuMin.entities;

/**
 * O elemento do tipo Atalho. Um atalho é um elemento que referencia um outro documento.
 */
public class Atalho extends Elemento {

    /**
     * O documento que está sendo referenciado pelo atalho.
     */
    private Documento documentoReferenciado;

    /**
     * Construtor do Atalho.
     *
     * @param valor                 O valor do atalho.
     * @param prioridade            A prioridade do atalho.
     * @param documentoReferenciado O documento que irá ser referenciado.
     */
    public Atalho(String valor, int prioridade, Documento documentoReferenciado) {
        super(valor, prioridade);
        this.documentoReferenciado = documentoReferenciado;
    }

    /**
     * Representação completa do Atalho. Ela é a representação completa de todos os elementos do documento que possuem
     * prioridade 4 e 5.
     * @return Uma string com a representação.
     */
    @Override
    public String representacaoCompleta() {
        String output = "";

        for (Elemento elem : documentoReferenciado.getElementos()) {
            if (elem.getPrioridade() == 4 || elem.getPrioridade() == 5) {
                output += elem.representacaoCompleta() + "\n";
            }
        }
        return output;
    }

    /**
     * Representação resumida do Atalho. Ela é a representação resumida de todos os elementos do documento que possuem
     * prioridade 4 e 5.
     * @return Uma string com a representação.
     */
    @Override
    public String representacaoResumida() {
        String output = "";

        for (Elemento elem : documentoReferenciado.getElementos()) {
            if (elem.getPrioridade() == 4 || elem.getPrioridade() == 5) {
                output += elem.representacaoResumida() + "\n";
            }
        }
        return output;
    }
}
