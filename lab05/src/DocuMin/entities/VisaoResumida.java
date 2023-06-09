package DocuMin.entities;

public class VisaoResumida extends Visao {

    public VisaoResumida(Documento docReferenciado) {
        super(docReferenciado);
    }

    @Override
    public String[] exibirVisao() {
        String[] output = new String[docReferenciado.getElementos().size()];

        for (int i = 0; i < output.length; i++) {
            output[i] = docReferenciado.getElemento(i).representacaoResumida();
        }
        return output;
    }
}
