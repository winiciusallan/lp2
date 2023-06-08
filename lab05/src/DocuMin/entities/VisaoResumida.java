package DocuMin.entities;

public class VisaoResumida extends Visao {

    public VisaoResumida(Documento doc) {
        super(doc);
    }

    @Override
    public String[] exibirVisao() {
        String[] output = new String[doc.getElementos().size()];
        for (int i = 0; i < doc.getElementos().size(); i++) {
            output[i] = doc.getElemento(i).representacaoResumida();
        }
        return output;
    }
}
