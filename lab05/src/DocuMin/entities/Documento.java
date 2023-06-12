package DocuMin.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * A representação de um documento. O documento é um conjunto de elementos e ele tem como identificador um título.
 * O documento pode ou não ter um tamanho máximo, ou seja, uma quantidade máxima de elementos.
 *
 * @author Winicius Allan - 122110397
 */
public class Documento {

    /**
     * O título do documento.
     */
    private String titulo;

    /**
     * O tamanho do elemento.
     */
    private int tamanho;

    /**
     * Uma coleção com os elementos do documento. Sendo armazenados na ordem em que são inseridos.
     */
    private ArrayList<Elemento> elementos;

    /**
     * Valor lógico indicando se o documento é ou não um atalho.
     */
    private boolean isAtalho;

    /**
     * Valor lógico indicando se o documento é referenciado por outro ou não.
     */
    private boolean hasAtalho;

    /**
     * Construtor de um documento. O documento pode ter quantidades não definidas de elementos.
     *
     * @param titulo O titulo do documento.
     */
    public Documento(String titulo) {
        this.titulo = titulo;
        this.tamanho = -1;
        this.elementos = new ArrayList<>();
    }

    /**
     * Construtor de um documento. O tamanho indica a quantidade de elementos que o documento pode ter.
     *
     * @param titulo  O título do documento.
     * @param tamanho O tamanho máximo do documento.
     */
    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>(tamanho);
    }

    public String getTitulo() { return titulo; }

    public int getTamanho() { return tamanho; }

    public boolean isAtalho() { return isAtalho; }

    public void setIsAtalho(boolean b) { this.isAtalho = b; }

    public boolean hasAtalho() { return hasAtalho; }

    public void setHasAtalho(boolean b) { this.hasAtalho = b; }

    public ArrayList<Elemento> getElementos() { return elementos; }

    /**
     * Pega um elemento na coleção em uma posição específica.
     *
     * @param pos A posição do elemento.
     * @return O elemento.
     */
    public Elemento getElemento(int pos) { return elementos.get(pos); }

    /**
     * Exibe o documento.
     *
     * @return Retorna um vetor com todas as representações resumidas dos elementos.
     */
    public String[] exibeDocumento() {
        String[] output = new String[elementos.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = elementos.get(i).representacaoResumida();
        }

        return output;
    }

    /**
     * Cria um elemento no documento.
     *
     * @param elem Elemento a ser criado.
     * @return     Posição do elemento na coleção.
     */
    public int criaElemento(Elemento elem) {
        this.elementos.add(elem);
        return elementos.indexOf(elem);
    }

    /**
     * Move o elemento uma posição acima do documento.
     *
     * @param pos A posição do elemento.
     * @return Valor lógico indicando se a operação deu certo ou não.
     */
    public boolean moverPosicaoAcima(int pos) {
        if (pos == 0) return false;
        Collections.swap(elementos, pos, pos + 1);
        return true;
    }

    /**
     * Move o elemento uma posição abaixo do documento.
     *
     * @param pos A posição do elemento.
     * @return Valor lógico indicando se foi movido ou não.
     */
    public boolean moverPosicaoAbaixo(int pos) {
        if (pos == elementos.size() ) return false;
        Collections.swap(elementos, pos, pos - 1);
        return true;
    }

    /**
     * Apaga um elemento do documento. Quando um elemento é retirado, não fica espaços em branco na coleção.
     *
     * @param pos A posição do elemento.
     * @return Valor lógico indicando se o elemento foi apagado ou não.
     */
    public boolean apagarElemento(int pos) {
        elementos.remove(pos);
        return true;
    }

    /**
     * Faz o cálculo da média de todas as prioridades dos elementos.
     *
     * @return Inteiro representando a média.
     */
    public int mediaPrioridade() {
        int output = 0;

        for (Elemento elem : elementos) {
            if (elem == null) return -1;
            output += elem.getPrioridade();
        }
        return output / elementos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(titulo, documento.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
