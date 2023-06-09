package DocuMin.entities;

public class VisaoCompleta extends Visao {

    public VisaoCompleta(Documento docReferenciado) {
        super(docReferenciado);
    }

    @Override
    public String[] exibirVisao() {
        String[] output = new String[docReferenciado.getElementos().size()];

        for (int i = 0; i < output.length; i++) {
            output[i] = docReferenciado.getElemento(i).representacaoCompleta();
        }
        return output;
    }
}
