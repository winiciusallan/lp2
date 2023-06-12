package DocuMin.entities;

/**
 * Um tipo de visão onde os elementos do documento referenciado são representados na sua forma completa.
 *
 * @author Winicius Allan - 122110397
 */
public class VisaoCompleta extends Visao {

    /**
     * Construtor da visão completa.
     *
     * @param docReferenciado O documento que será exportado pela visão
     */
    public VisaoCompleta(Documento docReferenciado) {
        super(docReferenciado);
    }

    /**
     * Exibe todos os elementos do documento que está sendo exportado, utilizando da representação completa deles.
     * @return Um vetor contendo a representação de cada elemento.
     */
    @Override
    public String[] exibirVisao() {
        String[] output = new String[docReferenciado.getElementos().size()];

        for (int i = 0; i < output.length; i++) {
            output[i] = docReferenciado.getElemento(i).representacaoCompleta();
        }
        return output;
    }
}
