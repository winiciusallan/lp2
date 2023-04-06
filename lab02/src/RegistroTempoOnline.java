/**
 * Representação do controle da quantidade de horas online em que o aluno está investindo em uma determinada disciplina
 * remota. Para o controle é necessário ter o nome, o tempo investido e a expectativa de investimento
 * de tempo de estudo na cadeira.
 *
 * @author Winicius Allan - 122110397
 */
public class RegistroTempoOnline {
    /**
     * O nome da disciplina que será monitorada.
     */
    private String nomeDaDisciplina;

    /**
     * A quantidade de tempo online que o aluno gastou estudando.
     */
    private int tempoGastoOnline;

    /**
     * O tempo que se espera que o aluno estude. Por padrão, espera-se 120 horas online.
     */
    private int tempoOnlineEsperado;

    /**
     * Construtor para criar o registro do tempo da disciplina.
     *
     * @param nomeDaDisciplina O nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Construtor para criar o registro do tempo da disciplina.
     *
     * @param nomeDaDisciplina O nome da disciplina.
     * @param tempoOnlineEsperado O tempo que se espera online.
     */
    public RegistroTempoOnline(String nomeDaDisciplina, int tempoOnlineEsperado) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public String getNomeDaDisciplina() { return nomeDaDisciplina; }

    public int getTempoGastoOnline() { return tempoGastoOnline; }

    public int getTempoOnlineEsperado() { return tempoOnlineEsperado; }

    public void adicionaTempoOnline(int tempo) {
        this.tempoGastoOnline += tempo;
    }

    /**
     * Método para verificar se o aluno atingiu a meta de tempo online
     *
     * @return um booleano indicando seu atingiu ou não
     */
    public boolean atingiuMetaTempoOnline() {
        return tempoGastoOnline >= tempoOnlineEsperado;
    }

    /**
     * @return Um relatório com o nome da disciplina, as horas gastas e as horas esperadas
     */
    @Override
    public String toString() {
        return getNomeDaDisciplina()
                + " "
                + String.format("%d/%d", getTempoGastoOnline(), getTempoOnlineEsperado());
    }
}