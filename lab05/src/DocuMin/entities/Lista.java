package DocuMin.entities;

/**
 * Um elemento do tipo lista. Uma lista tem um separador que é o que divide o valor, e um char que é concatenado no
 * início de cada termo da lista.
 *
 * @author Winicius Allan - 122110397
 */
public class Lista extends Elemento {

    /**
     * Separador do valor da lista.
     */
    private String separador;
    /**
     * O char da lista que indica o próximo termo da lista.
     */
    private String charLista;

    /**
     * Construtor de uma lista contendo seu valor e todas as suas prioridades.
     *
     * @param valorLista O valor da lista.
     * @param prioridade A prioridade da lista.
     * @param separador  O separador de cada linha da lista.
     * @param charLista  O char da lista.
     */
    public Lista(String valorLista, int prioridade, String separador, String charLista) {
        super(valorLista, prioridade);
        this.separador = separador;
        this.charLista = charLista;
    }

    public String getSeparador() { return separador; }

    public String getCharLista() { return charLista; }

    /**
     * Representação completa de uma lista. Ela é representada com o seu char pré-fixado e o seu valor. Cada termo da lista é
     * exibido linha a linha.
     * @return Uma string com a representação
     */
    @Override
    public String representacaoCompleta() {
        String[] valores = getValor().split(separador);
        String output = "";

        for (String valor : valores) {
            output += getCharLista() + " " + valor.trim() + "\n";
        }
        return output;
    }

    /**
     * Representação resumida de uma lista. A representação é cada termo da lista com o seu separador em seguida.
     * @return
     */
    @Override
    public String representacaoResumida() {
        String[] valores = getValor().split(getSeparador());
        String output = "";

        for (int i = 0; i < valores.length; i++) {
            if (i == valores.length - 1) {
                output += valores[i].trim();
                break;
            }
            output += valores[i].trim() + separador + " ";
        }
        return output;
    }
}
