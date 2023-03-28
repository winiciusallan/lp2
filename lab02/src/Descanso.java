/**
 *
 * @author Winicius Allan - 122110397
 */
public class Descanso {

    private int horasDeDescanso;
    private int numerosDeSemana;

    public Descanso() {
        this.horasDeDescanso = 0;
        this.numerosDeSemana = 1;
    }

    public int getHorasDeDescanso() { return horasDeDescanso;}

    public int getNumerosDeSemana() { return numerosDeSemana; }

    public void defineHorasDescanso(int valor) {
        this.horasDeDescanso = valor;
    }

    public void defineNumeroSemanas(int valor) {
        this.numerosDeSemana = valor;
    }

    public String getStatusGeral() {
        if (horasDeDescanso / numerosDeSemana >= 26) {
            return "descansado";
        }
        return "cansado";
    }
}
