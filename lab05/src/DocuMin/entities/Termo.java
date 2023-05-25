package DocuMin.entities;

public class Termo extends Elemento implements ElemInterface {

    private String separador;
    private String ordem;

    public Termo(String valorTermos, int prioridade, String separador, String ordem) {
        super(valorTermos, prioridade);
        this.separador = separador;
        this.ordem = ordem;
    }

    @Override
    public String representacaoCompleta() {
        return null;
    }

    @Override
    public String representacaoResumida() {
        return null;
    }
}
