package DocuMin.entities;

public class VisaoTitulo extends Visao {

    public VisaoTitulo(Documento docReferenciado) {
        super(docReferenciado);
    }

    @Override
    public String[] exibirVisao() {
        String[] output = new String[docReferenciado.getElementos().size()];

        for (int i = 0; i < output.length; i++) {
            if (docReferenciado.getElemento(i) instanceof Titulo) {
                output[i] = docReferenciado.getElemento(i).representacaoResumida();
            }
        }
        return output;
    }
}
