/**
 * Representar todas as informações sobre o descanso do aluno. Tais como verificar o Status do aluno
 * dependendo da quantidade de horas estudadas, definir as horas de descanso e a o número da semana do semestre.
 *
 * @author Winicius Allan - 122110397
 */
public class Descanso {

    /**
     * Quantidades de horas de descanso que o aluno está tendo.
     */
    private int horasDeDescanso;

    /**
     * Número da semana em que o aluno se encontra. Sempre começa da semana 1.
     */
    private int numerosDeSemana;

    /**
     * Construtor para Descanso, definindo valores padrão das horas de descanso e do número de semanas.
     */
    public Descanso() {
        this.horasDeDescanso = 0;
        this.numerosDeSemana = 1;
    }

    /**
     * É um setter para o atributo das horas de descanso
     *
     * @param valor quantidade de horas descansadas.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDeDescanso = valor;
    }

    /**
     * É um setter para o atributo do números de semanas.
     *
     * @param valor numero de semanas decorridas.
     */
    public void defineNumeroSemanas(int valor) {
        this.numerosDeSemana = valor;
    }

    /**
     * Verifica se o aluno descansou as 26 horas estabelecidas por semana e verifica se está cansado ou descansado.
     *
     * @return o status do aluno.
     */
    public String getStatusGeral() {
        if (horasDeDescanso / numerosDeSemana >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}
