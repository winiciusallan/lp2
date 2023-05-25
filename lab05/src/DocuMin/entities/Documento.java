package DocuMin.entities;

import java.util.ArrayList;
import java.util.Objects;

public class Documento {

    private String titulo;
    private int tamanho;
    private ArrayList<Elemento> elementos;

    public Documento(String titulo) {
        this.titulo = titulo;
        this.elementos = new ArrayList<>();
    }

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>(tamanho);
    }

    public String getTitulo() { return titulo; }

    public int getTamanho() { return tamanho; }

    public ArrayList<Elemento> getElementos() { return elementos; }

    public Elemento getElemento(int pos) { return elementos.get(pos); }

    public String[] exibeDocumento() {
        String[] output = new String[elementos.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = elementos.get(i).toString(); // Implements elemento toString.
        }

        return output;
    }

    public int criaElemento(Elemento elem) {
        this.elementos.add(elem);
        return elementos.indexOf(elem);
    }

    public boolean moverPosicaoAcima(Elemento elem) {
        if (elementos.indexOf(elem) == 0) return false;

        Elemento elemAnterior = elementos.get(elementos.indexOf(elem) - 1);
        Elemento aux = elementos.get(elementos.indexOf(elem));

        elem = elemAnterior;
        elemAnterior = aux;
        return true;
    }

    public boolean moverPosicaoAbaixo(Elemento elem) {
        if (elementos.indexOf(elem) == elementos.size() ) return false;

        Elemento elemSeguinte = elementos.get(elementos.indexOf(elem) + 1);
        Elemento aux = elementos.get(elementos.indexOf(elem));

        elem = elemSeguinte;
        elemSeguinte = aux;
        return true;
    }

    public boolean apagarElemento(Elemento elem) {
        return elementos.remove(elem);
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
