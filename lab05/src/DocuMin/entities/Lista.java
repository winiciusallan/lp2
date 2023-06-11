package DocuMin.entities;

public class Lista extends Elemento {

    private String separador;
    private String charLista;

    public Lista(String valorLista, int prioridade, String separador, String charLista) {
        super(valorLista, prioridade);
        this.separador = separador;
        this.charLista = charLista;
    }

    public String getSeparador() { return separador; }

    public String getCharLista() { return charLista; }

    @Override
    public String representacaoCompleta() {
        String[] valores = getValor().split(separador);
        String output = "";

        for (String valor : valores) {
            output += getCharLista() + " " + valor.trim() + "\n";
        }
        return output;
    }

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
