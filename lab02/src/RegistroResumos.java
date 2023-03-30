/**
 *
 * @author Winicius Allan - 122110397
 */
public class RegistroResumos {

    private String[] resumos;
    private String[] conteudo;

    /**
     * Atributo de controle de índice dos arrays
     */
    private int posicaoAtual;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new String[numeroDeResumos];
        this.conteudo = new String[numeroDeResumos];
        this.posicaoAtual = 0;
    }

    public String[] pegaResumos() { return resumos; }

    public int conta() {
        int cont = 0;

        for (String resumo : resumos) {
            if (resumo != null) {
                cont++;
            }
        }

        return cont;
    }

    public void adiciona(String tema, String resumo) {

        resumos[posicaoAtual] = tema + ": " + resumo;
        conteudo[posicaoAtual] = tema;

        if (posicaoAtual == resumos.length) { posicaoAtual = 0; }
        else { posicaoAtual++; }

//        for (int i = 0; i < resumos.length; i++) {
//            if (resumos[i] == null) {
//                resumos[i] = tema + ": " + resumo;
//                conteudo[i] = tema;
//                return;
//            }
//        }
    }

    public boolean temResumo(String tema) {

        for (int i = 0; i < conta(); i++) {
            if (conteudo[i].equals(tema)) {
                return true;
            }
        }

        return false;
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
