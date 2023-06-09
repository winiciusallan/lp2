package DocuMin.entities;

public class VisaoPrioritaria extends Visao {

    private int prioridade;

    public VisaoPrioritaria(Documento docReferenciado, int prioridade) {
        super(docReferenciado);
        this.prioridade = prioridade;
    }

    public int getPrioridade() { return prioridade; }

    @Override
    public String[] exibirVisao() {
        String[] output = new String[docReferenciado.getElementos().size()];

        for (int i = 0; i < output.length; i++) {
            if (docReferenciado.getElemento(i).getPrioridade() >= prioridade) {
                output[i] = docReferenciado.getElemento(i).representacaoCompleta();
            }
        }
        return output;
    }
}
