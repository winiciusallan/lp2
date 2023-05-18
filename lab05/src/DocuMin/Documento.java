package DocuMin;

import java.util.Objects;

public class Documento {

    private String titulo;
    private int tamanho;

    public Documento(String titulo) {
        this.titulo = titulo;
        this.tamanho = Integer.MAX_VALUE;
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
    }

    public String getTitulo() { return titulo; }

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
