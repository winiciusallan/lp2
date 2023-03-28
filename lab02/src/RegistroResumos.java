/**
 *
 * @author Winicius Allan - 122110397
 */
public class RegistroResumos {

    private String[] resumos;
    private String[] conteudo;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new String[numeroDeResumos];
        this.conteudo = new String[numeroDeResumos];
    }

    public String[] pegaResumos() { return resumos; }

    public void adiciona(String tema, String resumo) {
        for (int i = 0; i < resumos.length; i++) {
            if (resumos[i] == null) {
                resumos[i] = tema + ": " + resumo;
                conteudo[i] = tema;
                break;
            }
        }
    }

    public int conta() {
        int cont = 0;

        for (String resumo : resumos) {
            if (resumo != null) { cont++; }
        }

        return cont;
    }

    public boolean temResumo(String tema) {
        boolean exists = false;
        for (int i = 0; i < conta(); i++) {
            if (conteudo[i].equals(tema)) {
                exists = true;
                break;
            }
        }

        return exists;
    }

    public String imprimeResumos() {
        String primeiraLinha = "- " + conta() + " resumos(s) cadastrado(s)";
        StringBuilder segundaLinha = new StringBuilder("- "); // StringBuilder para criar uma string concatenada;

        for (int i = 0; i < conta(); i++) {
            if (i == 0) {
                segundaLinha.append(conteudo[i]);
            } else {
                segundaLinha.append(" | ").append(conteudo[i]);
            }
        }
        return primeiraLinha + "\n" + segundaLinha;
    }
}
