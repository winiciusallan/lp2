package DocuMin.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Documento {

    private String titulo;
    private int tamanho;
    private ArrayList<Elemento> elementos;
    private boolean isAtalho;
    private boolean hasAtalho;

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

    public boolean isAtalho() { return isAtalho; }

    public void setIsAtalho(boolean b) { this.isAtalho = b; }

    public boolean hasAtalho() { return hasAtalho; }

    public void setHasAtalho(boolean b) { this.hasAtalho = b; }

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

    public boolean moverPosicaoAcima(int pos) {
        if (pos == 0) return false;
        Collections.swap(elementos, pos, pos + 1);
        return true;
    }

    public boolean moverPosicaoAbaixo(int pos) {
        if (pos == elementos.size() ) return false;
        Collections.swap(elementos, pos, pos - 1);
        return true;
    }

    public boolean apagarElemento(int pos) {
        elementos.remove(pos);
        return true;
    }

    public int mediaPrioridade() {
        int output = 0;

        for (Elemento elem : elementos) {
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
