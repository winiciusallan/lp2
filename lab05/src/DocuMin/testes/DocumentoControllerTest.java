package DocuMin.testes;

import DocuMin.controllers.DocumentoController;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DocumentoControllerTest {

    private DocumentoController docBase;

    @Before
    public void setUp() {
        docBase = new DocumentoController();
    }

    @Test
    public void criarUmDocumentoComSucesso() throws IllegalAccessException {
        assertTrue(docBase.criarDocumento("Aula de p2. Isso é um teste"));
    }

    @Test
    public void criarUmDocumentoQueJaExiste() throws IllegalAccessException {
        docBase.criarDocumento("Aula de p2.");
        assertFalse(docBase.criarDocumento("Aula de p2."));
    }

    @Test
    public void criarUmDocumentoComTamanhoZero() {
        assertThrows(IllegalAccessException.class,
                () -> docBase.criarDocumento(""));
    }

    @Test
    public void criarUmDocumentoComTamanhoMaximo() throws IllegalAccessException {
        assertTrue(docBase.criarDocumento("Aula de lp2.", 10));
    }

    @Test
    public void removerUmDocumentoComSucesso() throws IllegalAccessException {
        docBase.criarDocumento("Testando");
        docBase.removerDocumento("Testando");
    }

    @Test
    public void removerDocumentoQueNaoExiste() {
        assertThrows(NoSuchElementException.class,
                () -> docBase.removerDocumento("Documento não existe"));
    }

    @Test
    public void removerDocumentoComTituloInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> docBase.removerDocumento(""));
    }

    @Test
    public void contaElementosComSucesso() {
        assertTrue(docBase.contarElementos(""));
    }
}
