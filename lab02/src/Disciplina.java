import java.util.Arrays;

/**
 *
 * @author Winicius Allan - 122110397
 */
public class Disciplina {

    private String nomeDaDisciplina;
    private int horasDeEstudo;
    private double[] notas;

    public Disciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[4];
    }

    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    public int getHorasDeEstudo() { return horasDeEstudo; }

    public void cadastraHoras(int horas) { this.horasDeEstudo += horas; }

    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;
    }

    public double calculaMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    @Override
    public String toString() {
        return getNomeDaDisciplina()
                + " "
                + getHorasDeEstudo()
                + " "
                + calculaMedia()
                + " "
                + Arrays.toString(notas);
    }

}
