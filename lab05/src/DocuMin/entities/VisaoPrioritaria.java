package DocuMin.entities;

import java.util.ArrayList;

/**
 * Um tipo de visão onde os elementos são representados utilizando suas prioridades como parâmetro.
 *
 * @author Winicius Allan - 122110397
 */
public class VisaoPrioritaria extends Visao {

    /**
     * A prioridade usada como parâmetro.
     */
    private int prioridade;

    /**
     * Construtor da visão prioritária.
     *
     * @param docReferenciado O documento que será exportado.
     * @param prioridade      A sua prioridade.
     */
    public VisaoPrioritaria(Documento docReferenciado, int prioridade) {
        super(docReferenciado);
        this.prioridade = prioridade;
    }

    public int getPrioridade() { return prioridade; }

    /**
     * Exibe a representação completa de todos os elementos que tiverem a prioridade maior ou igual a que é usada como
     * parâmetro
     * @return Vetor contendo a representação textual dos elementos.
     */
    @Override
    public String[] exibirVisao() {
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < docReferenciado.getElementos().size() ; i++) {
            if (docReferenciado.getElemento(i).getPrioridade() >= prioridade) {
                output.add(docReferenciado.getElemento(i).representacaoCompleta());
            }
        }

        return output.toArray(new String[0]);
    }
}
