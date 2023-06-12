package DocuMin.entities;

/**
 * Um elemento do tipo texto.
 * @author Winicius Allan - 122110397
 */
public class Texto extends Elemento {

    /**
     * Construtor do texto.
     *
     * @param valor      Valor do texto.
     * @param prioridade A prioridade do texto.
     */
    public Texto(String valor, int prioridade) {
        super(valor, prioridade);
    }

    /**
     * A representação completa de um texto é apenas o seu valor.
     * @return A representação na forma de uma string.
     */
    @Override
    public String representacaoCompleta() {
        return valor;
    }

    /**
     * A representação resumida de um texto é apenas o seu valor.
     * @return A representação na forma de uma string.
     */
    @Override
    public String representacaoResumida() {
        return valor;
    }
}
