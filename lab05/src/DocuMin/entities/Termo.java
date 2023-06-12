package DocuMin.entities;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Um elemento do tipo Termo. Um termo é um conjunto de palavras divididas por um separador. Podem ser ordenadas ou não
 *
 * @author Winicius Allan - 122110397
 */
public class Termo extends Elemento {

    /**
     * O separador do termo.
     */
    private String separador;
    /**
     * A ordem indica como os termos estão ordenados.
     */
    private String ordem;

    /**
     * Construtor do termo.
     *
     * @param valorTermos O valor do termo.
     * @param prioridade  A prioridade do termo.
     * @param separador   O separador do termo.
     * @param ordem       A ordenação do termo.
     */
    public Termo(String valorTermos, int prioridade, String separador, String ordem) {
        super(valorTermos, prioridade);
        this.separador = separador;
        this.ordem = ordem;
    }

    public String getSeparador() { return separador; }

    public String getOrdem() { return ordem; }

    /**
     * Representação completa do termo. Ela mostra a quantidade de termos que têm, cada um separador por vírgula e ordenado
     * de acordo com a ordem.
     * @return A representação sendo uma string.
     */
    @Override
    public String representacaoCompleta() {
        String[] valores = getValor().split(getSeparador());
        String output = "Total termos: " + valores.length + "\n- ";

        switch (this.ordem) {
            case "TAMANHO" -> Arrays.sort(valores, new OrdenaTamanho());
            case "ALFABETICA" -> Arrays.sort(valores, String::compareToIgnoreCase);
        };

        for (int i = 0; i < valores.length; i++) {
            if (i == valores.length - 1) {
                output += valores[i];
            } else {
                output += valores[i] + ", ";
            }
        }
        return output;
    }

    /**
     * Representação resumida do termo. Mostra cada termo separado pelo separador e ordenado de acordo com a ordem.
     *
     * @return A representação sendo uma string.
     */
    @Override
    public String representacaoResumida() {
        String[] valores = getValor().split(getSeparador());
        String output = "";

        switch (this.ordem) {
            case "TAMANHO" -> Arrays.sort(valores, new OrdenaTamanho());
            case "ALFABETICA" -> Arrays.sort(valores, String::compareToIgnoreCase);
        };

        for (int i = 0; i < valores.length; i++) {
            if (i == valores.length - 1) {
                output += valores[i];
            } else {
                output += valores[i] + " " + getSeparador() + " ";
            }
        }
        return output;
    }

    /**
     * Uma classe que implementa a ordenação dos termos por tamanho deles.
     */
    public class OrdenaTamanho implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o2.length(), o1.length());
        }
    }
}
