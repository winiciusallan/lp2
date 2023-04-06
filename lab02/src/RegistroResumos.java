import java.util.ArrayList;
import java.util.Collections;

/**
 * Representação de um registro de resumos onde é possível armazenar os resumos dos alunos e os seus
 * respectivos conteúdos dentro de um vetor. Além de fazer uma busca utilizando uma palavra-chave
 * e imprimir um relatório com os resumos cadastrados.
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

    /**
     * Construtor para o registro dos resumos, criando um vetor para armazenar os resumos e outro vetor com os temas
     * dos respectivos resumos.
     *
     * @param numeroDeResumos número máximo de resumos que serão armazenados.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new String[numeroDeResumos];
        this.conteudo = new String[numeroDeResumos];
        this.posicaoAtual = 0;
    }

    public String[] pegaResumos() { return resumos; }

    /**
     * Método que realiza da contagem de resumos no vetor. Verifica quais elementos não são null e incrementa a contagem.
     *
     * @return a quantidade de resumos armazenados.
     */
    public int conta() {
        int cont = 0;

        for (String resumo : resumos) {
            if (resumo != null) {
                cont++;
            }
        }

        return cont;
    }

    /**
     * Adiciona um resumo no array.
     * Caso o vetor já esteja totalmente completo, o primeiro é substituido, depois o segundo e assim por diante.
     *
     * @param tema o tema ao qual o resumo se refere.
     * @param resumo o resumo.
     */
    public void adiciona(String tema, String resumo) {

        if (posicaoAtual == resumos.length) { posicaoAtual = 0; }

        resumos[posicaoAtual] = tema + ": " + resumo;
        conteudo[posicaoAtual] = tema;

        posicaoAtual++;
    }

    /**
     * Verifica no array se existe um resumo sobre um determinado tema.
     *
     * @param tema o tema a ser procurado no vetor.
     * @return um booleano indicando se existe ou não existe.
     */
    public boolean temResumo(String tema) {

        for (int i = 0; i < conta(); i++) {
            if (conteudo[i].equals(tema)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Método para buscar se os resumos contêm uma palavra-chave.
     *
     * @param chaveDeBusca a palavra que irá verificar se contém.
     * @return retorna um vetor ordenado com os temas dos resumos que contém a chave de busca.
     */
    public ArrayList<String> busca(String chaveDeBusca) {
        ArrayList<String> resultados = new ArrayList<>();

        for (int i = 0; i < resumos.length; i++) {
            if (resumos[i] == null) { break; }

            if (resumos[i].contains(chaveDeBusca)) { // Verifica se contem a chave dentro dos resumos
                resultados.add(conteudo[i]);
            }
        }

        Collections.sort(resultados);
        return resultados;
    }

    /**
     * Imprime um relatório dos resumos.
     *
     * @return a quantidade de resumos que foram cadastrados e todos os conteúdos cadastrados.
     */
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