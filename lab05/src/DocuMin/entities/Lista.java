package DocuMin.entities;

public class Lista extends Elemento {

    private String separador;
    private String charLista;

    public Lista(String valorLista, int prioridade, String separador, String charLista) {
        super(valorLista, prioridade);
    }

    public String getSeparador() { return separador; }

    public String getCharLista() { return charLista; }

    @Override
    public String representacaoCompleta() {
        String[] valores = getValor().split(getSeparador());
        String output = "";

        for (String charr : valores) {
            output += getCharLista() + " " + charr + "\n";
        }
        return output;
    }

    @Override
    public String representacaoResumida() {
        String[] valores = getValor().split(getSeparador());
        String output = "";

        for (String charr : valores) {
            output += charr + getSeparador() + " ";
        }
        return output;
    }
}
