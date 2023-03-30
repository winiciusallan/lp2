/**
 *
 * @author Winicius Allan - 122110397
 */
public class RegistroResumos {

    /**
     * Um vetor que contém os resumos relacionados a um tema.
     */
    private String[] resumos;

    /**
     * Um vetor que armazena os conteúdos tratados nos resumos.
     */
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

        if (posicaoAtual == resumos.length) { posicaoAtual = 0; }

        resumos[posicaoAtual] = tema + ": " + resumo;
        conteudo[posicaoAtual] = tema;

        posicaoAtual++;

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

    /**
     * Método para buscar se os resumos contém uma palavra-chave
     *
     * @param chaveDeBusca a palavra que irá verificar se contém
     * @return retorna um vetor com os temas dos resumos que contém a chave de busca
     */
    public String[] busca(String chaveDeBusca) {
        String[] resultados = new String[conta()];

        for (int i = 0; i < resumos.length; i++) {
            if (resumos[i] == null) { return resultados; }

            if (resumos[i].contains(chaveDeBusca)) { // Verifica se contem a chave dentro dos resumos
                resultados[i] = conteudo[i];
            }
        }

        return resultados;
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
