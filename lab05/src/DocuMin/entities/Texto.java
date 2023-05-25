package DocuMin.entities;

public class Texto extends Elemento implements ElemInterface {

    public Texto(String valor, int prioridade) {
        super(valor, prioridade);
    }

    @Override
    public String representacaoCompleta() {
        return valor;
    }

    @Override
    public String representacaoResumida() {
        return valor;
    }
}
