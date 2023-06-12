package DocuMin.testes;

import DocuMin.entities.Documento;
import DocuMin.entities.Texto;
import DocuMin.entities.Titulo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentoTest {

    Documento docBase;

    @Before
    public void setUp() {
        this.docBase = new Documento("Documento base");
    }

    @Test
    public void criandoElementoNoDocumento() {
        docBase.criaElemento(new Texto("Texto", 5));
        assertTrue(docBase.getElemento(0) instanceof Texto);
    }

    @Test
    public void exibindoDocumento() {

    }

    @Test
    public void movendoElementoPosicaoAcima() {
        docBase.criaElemento(new Texto("Texto 1", 5));
        docBase.criaElemento(new Titulo("Titulo 1", 5, 1, false));

        docBase.moverPosicaoAcima(1);
        assertTrue(docBase.getElemento(0) instanceof Titulo);
    }

    @Test
    public void movendoElementoPosicaoAcimaPosicaoInvalida() {
        docBase.criaElemento(new Texto("Texto 1", 5));
        docBase.criaElemento(new Titulo("Titulo 1", 5, 1, false));

        assertFalse(docBase.moverPosicaoAcima(0));
    }

    @Test
    public void movendoElementoPosicaoAbaixo() {
        docBase.criaElemento(new Texto("Texto 1", 5));
        docBase.criaElemento(new Titulo("Titulo 1", 5, 1, false));

        docBase.moverPosicaoAbaixo(0);
        assertTrue(docBase.getElemento(1) instanceof Texto);
    }

    @Test
    public void movendoElementoPosicaoAbaixoPosicaoInvalida() {
        docBase.criaElemento(new Texto("Texto 1", 5));
        docBase.criaElemento(new Titulo("Titulo 1", 5, 1, false));

        assertFalse(docBase.moverPosicaoAbaixo(1));
    }

    @Test
    public void apagandoElementoDoDocumento() {
        docBase.criaElemento(new Texto("Texto 1", 5));
        docBase.apagarElemento(0);
        assertEquals(0, docBase.getElementos().size());
    }
}
