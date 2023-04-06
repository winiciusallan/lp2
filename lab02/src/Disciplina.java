import java.util.Arrays;

/**
 * Representação de uma disciplina de um estudante de Ciência da Computação na UFCG. Identificado pelo seu nome
 * e as suas respectivas notas. Além de um monitoramento das horas dedicadas a estudos nessa cadeira.
 *
 * @author Winicius Allan - 122110397
 */
public class Disciplina {

    /**
     * Atibuto que representa o nome da disciplina criada.
     */
    private String nomeDaDisciplina;

    /**
     * Atributo que representa a quantidade de horas estudadas na disciplina.
     */
    private int horasDeEstudo;

    /**
     * Um vetor que contem as notas da disciplina.
     */
    private double[] notas;

    /**
     * Um vetor com os pesos das notas (caso exista). Seção bônus.
     */
    private int[] pesos;

    /**
     * Construtor para criação da disciplina.
     *
     * @param nomeDaDisciplina O nome da disciplina criada.
     */
    public Disciplina(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[4];
    }

    /**
     * Construtor para criação da disciplina e suas notas.
     *
     * @param nomeDaDisciplina O nome da disciplina criada.
     * @param numeroDeNotas A quantidade de notas que aquela disciplina terá.
     */
    public Disciplina(String nomeDaDisciplina, int numeroDeNotas){
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[numeroDeNotas];
    }

    /**
     * Construtor para a criação da disciplina com notas ponderadas.
     *
     * @param nomeDaDisciplina O nome da disciplina criada.
     * @param numeroDeNotas A quantidade de notas que a disciplina terá.
     * @param pesos Um array de inteios com o peso de cada nota.
     */
    public Disciplina(String nomeDaDisciplina, int numeroDeNotas, int[] pesos) {
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.horasDeEstudo = 0;
        this.notas = new double[numeroDeNotas];
        this.pesos = pesos;
    }

    /**
     * Método para acessar o nome da disciplina.
     * @return o nome da Disciplina.
     */
    public String getNomeDaDisciplina() {
        return nomeDaDisciplina;
    }

    /**
     * Método para acessar a quantidade de horas estudadas.
     * @return
     */
    public int getHorasDeEstudo() { return horasDeEstudo; }

    /**
     * Método para adicinar horas estudadas na disciplina.
     * @param horas quantidade de horas estudadas.
     */
    public void cadastraHoras(int horas) { this.horasDeEstudo += horas; }

    /**
     * Método para cadastrar no vetor uma nota da disciplina.
     *
     * @param nota O índice da nota que vai ser adicionada.
     * @param valorNota O valor da nota que o aluno tirou em ponto flutuante.
     */
    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;
    }

    /**
     * Método para calcular a média do aluno (aritmética).
     *
     * @return a média das notas.
     */
    public double calculaMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    /**
     * Método para calcular a média do aluno (ponderada).
     *
     * @return a média ponderada.
     */
    public double calculaMediaPonderada() {
        double soma = 0;
        int somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }

        return soma / somaPesos;
    }

    /**
     * Método para dizer se o aluno foi aprovado ou não. O aluno é aprovado quando sua média é maior ou igual a 7.0.
     *
     * @return um boolean indicando true caso o aluno tiver passado, e false caso tenha reprovado.
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Método para mostrar um relatório das horas estudadas na disciplina, sua média e as suas notas.
     *
     * @return o relatório da disciplina.
     */
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