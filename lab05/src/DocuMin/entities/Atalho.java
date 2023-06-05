package DocuMin.entities;

public class Atalho extends Elemento {

    private Documento documentoReferenciado;

    public Atalho(String valor, int prioridade, Documento documentoReferenciado) {
        super(valor, prioridade);
        this.documentoReferenciado = documentoReferenciado;
    }

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
