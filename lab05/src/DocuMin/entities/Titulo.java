package DocuMin.entities;

/**
 * Elemento do tipo titulo. Ele pode ter níveis de título e indicando se ele é linkável ou não.
 * @author Winicius Allan - 122110397
 */
public class Titulo extends Elemento {

    /**
     * O nível do título.
     */
    private int nivel;
    /**
     * Um valor lógico indicando se o título é linkável ou não.
     */
    private boolean linkavel;

    /**
     * Construtor do titulo.
     *
     * @param valor      O valor do título
     * @param prioridade A prioridade do título.
     * @param nivel      O nível do título.
     * @param linkavel   Se o título é linkável.
     */
    public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
        super(valor, prioridade);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    public int getNivel() { return nivel; }

    public boolean getLinkavel() { return linkavel; }

    /**
     * Representação completa do título. A representação completa tem o nível do titulo, seguido do seu valor e, caso seja
     * linkável, contem uma "corrente" --.
     * @return A representação do titulo em forma de String.
     */
    @Override
    public String representacaoCompleta() {
        if (linkavel) return getNivel() + ". " + getValor() + " --\n"
                            + getNivel() + "-" + getValor().replace(" ", "").toUpperCase();

        return getNivel() + ". " + getValor();
    }

    /**
     * Representação resumida do título. A representação resumida é o nível do título seguido do seu valor.
     * @return A representação do titulo em forma de String.
     */
    @Override
    public String representacaoResumida() {
        return getNivel() + ". " + getValor();
    }
}
