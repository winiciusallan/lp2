package DocuMin.entities;

public class Titulo extends Elemento implements ElemInterface {

    private int nivel;
    private boolean linkavel;

    public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
        super(valor, prioridade);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    public int getNivel() { return nivel; }

    public boolean getLinkavel() { return linkavel; }

    @Override
    public String representacaoCompleta() {
        return null;
    }

    @Override
    public String representacaoResumida() {
        return null;
    }
}
