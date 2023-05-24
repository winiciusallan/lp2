package DocuMin.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Documento {

    private String titulo;
    private int tamanho;
    private ArrayList<Elemento> elementos;

    public Documento(String titulo) {
        this.titulo = titulo;
        this.tamanho = Integer.MAX_VALUE;
        this.elementos = new ArrayList<>();
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>();
    }

    public String getTitulo() { return titulo; }

    public int getTamanho() { return tamanho; }

    public ArrayList<Elemento> getElementos() { return elementos; }

    public String[] exibeDocumento() {
        String[] output = new String[elementos.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = elementos[i].toString(); // Implements elemento toString.
        }

        return output;
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
