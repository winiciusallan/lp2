/**
 *
 * @author Winicius Allan - 122110397
 */
public class RegistroTempoOnline {

    private String nomeDaDisciplina;
    private int tempoGastoOnline;
    private int tempoOnlineEsperado;

    public RegistroTempoOnline(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.tempoOnlineEsperado = 120;
    }

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

    public boolean atingiuMetaTempoOnline() {
        return tempoGastoOnline >= tempoOnlineEsperado;
    }

    @Override
    public String toString() {
        return getNomeDaDisciplina()
                + " "
                + String.format("%d/%d", getTempoGastoOnline(), getTempoOnlineEsperado());
    }
}
