package DocuMin.testes;

import DocuMin.controllers.DocumentoController;
import org.junit.Before;
import org.junit.Test;

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
}
