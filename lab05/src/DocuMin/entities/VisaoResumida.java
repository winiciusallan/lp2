package DocuMin.entities;

/**
 * Representação de um tipo de visão onde os elementos estão na sua forma resumida.
 *
 * @author Winicius Allan - 122110397.
 */
public class VisaoResumida extends Visao {

    /**
     * Construtor da visão resumida.
     *
     * @param docReferenciado the doc referenciado
     */
    public VisaoResumida(Documento docReferenciado) {
        super(docReferenciado);
    }

    /**
     * Exibe a representação resumida de todos os elementos do documento referenciado.
     * @return Um vetor contendo as representações em texto dos elementos.
     */
    @Override
    public String[] exibirVisao() {
        String[] output = new String[docReferenciado.getElementos().size()];

        for (int i = 0; i < output.length; i++) {
            output[i] = docReferenciado.getElemento(i).representacaoResumida();
        }
        return output;
    }
}
