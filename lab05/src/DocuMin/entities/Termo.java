package DocuMin.entities;

import java.util.Arrays;
import java.util.Comparator;

public class Termo extends Elemento {

    private String separador;
    private String ordem;

    public Termo(String valorTermos, int prioridade, String separador, String ordem) {
        super(valorTermos, prioridade);
        this.separador = separador;
        this.ordem = ordem;
    }

    public String getSeparador() { return separador; }

    public String getOrdem() { return ordem; }

    @Override
    public String representacaoCompleta() {
        String[] valores = getValor().split(getSeparador());
        String output = "Total de termos: " + valores.length + "\n- ";

        switch (this.ordem) {
            case "TAMANHO" -> Arrays.sort(valores, new OrdenaTamanho());
            case "ALFABETICA" -> Arrays.sort(valores);
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

    @Override
    public String representacaoResumida() {
        String[] valores = getValor().split(getSeparador());
        String output = "";

        switch (this.ordem) {
            case "TAMANHO" -> Arrays.sort(valores, new OrdenaTamanho());
            case "ALFABETICA" -> Arrays.sort(valores);
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

    public class OrdenaTamanho implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o2.length(), o1.length());
        }
    }
}
