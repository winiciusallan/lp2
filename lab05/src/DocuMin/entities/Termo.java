package DocuMin.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
        return null; // To be implemented
    }

    @Override
    public String representacaoResumida() {
        String[] valores = getValor().split(getSeparador());
        String output = "";

        switch (this.ordem) {
            case "TAMANHO" -> Arrays.sort(valores, new OrdenaTamanho());
            case "ALFABÉTICA" -> Arrays.sort(valores);
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
            return o1.compareTo(o2);
        }
    }
}
