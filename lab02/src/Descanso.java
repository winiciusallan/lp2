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
     * Emoji que representa como o aluno está.
     */
    private String emoji;

    /**
     * O estado atual do aluno. Podendo estar cansado ou descansado.
     */
    private String atualEstado;

    /**
     * O próximo estado do aluno que será registrado.
     */
    private String proxEstado;

    /**
     * Construtor para Descanso, definindo valores padrão das horas de descanso e do número de semanas.
     */
    public Descanso() {
        this.horasDeDescanso = 0;
        this.numerosDeSemana = 1;
        this.emoji = "";
        this.atualEstado = "";
        this.proxEstado = "";
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

    public void definirEmoji(String emoji) { this.emoji = emoji; }

    /**
     * Verifica se o aluno descansou as 26 horas estabelecidas por semana e verifica se está cansado ou descansado.
     *
     * @return o status do aluno.
     */
    public String getStatusGeral() {

        if (horasDeDescanso / numerosDeSemana >= 26) {
            if (numerosDeSemana == 1) {
                this.atualEstado = "descansado";
                this.proxEstado = atualEstado;
            } else {
                this.proxEstado = "descansado";
            }
        } else {
            if (numerosDeSemana == 1) { this.atualEstado = "cansado"; }
            else {
                this.proxEstado = "cansado";
            }
        }

        if (proxEstado.equals(atualEstado)) {
            return proxEstado + " - " + this.emoji;
        }

        return proxEstado;
    }
}
