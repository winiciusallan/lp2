package DocuMin.testes;

import DocuMin.controllers.DocumentoController;
import DocuMin.entities.Lista;
import DocuMin.entities.Termo;
import DocuMin.entities.Texto;
import DocuMin.entities.Titulo;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DocumentoControllerTest {

    private DocumentoController docBase;

    @Before
    public void setUp() throws IllegalAccessException {
        docBase = new DocumentoController();
        docBase.criarDocumento("Documento base");
    }

    /* TESTES PARA DOCUMENTO */

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

    /* TESTES PARA ELEMENTO */

    @Test
    public void criarElementoTextoComSucesso() {
        assertEquals(0, docBase.criaElemento("Documento base", new Texto("Texto", 3)));
    }

    @Test
    public void criarElementoTituloComSucesso() {
        assertEquals(0, docBase.criaElemento("Documento base", new Titulo("Titulo", 3,
                1, true)));
    }

    @Test
    public void criarElementoListaComSucesso() {
        assertEquals(0, docBase.criaElemento("Documento base", new Lista("Titulo", 3,
                "/", "-")));
    }

    @Test
    public void criarElementoTermosComSucesso() {
        assertEquals(0, docBase.criaElemento("Documento base", new Termo("Titulo", 3,
                "/", "NENHUM")));
    }

    @Test
    public void contaElementosComSucesso() {
        docBase.criaElemento("Documento base", new Texto("Titulo", 3));

        assertEquals(1, docBase.contarElementos("Documento base"));
    }

    @Test
    public void contarElementosDocumentoNaoCadastrado() {
        docBase.criaElemento("Documento base", new Texto("Titulo", 3));

        assertThrows(NoSuchElementException.class,
                () -> docBase.contarElementos("Documento falso"));
    }

    @Test
    public void contarElementosNomeDocumentoVazio() {
        docBase.criaElemento("Documento base", new Texto("Titulo", 3));

        assertThrows(IllegalArgumentException.class,
                () -> docBase.contarElementos(""));
    }

    @Test
    public void exibirDocumentoComSucesso() {
        assertTrue(docBase.exibirDocumento("Documento base") instanceof String[]);
    }

    @Test
    public void exibirDocumentoQueNaoExiste() {
        assertThrows(NoSuchElementException.class,
                () -> docBase.exibirDocumento("Documento falso"));
    }

    @Test
    public void exibirDocumentoComTituloVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> docBase.exibirDocumento(""));
    }

    @Test
    public void textoRepresentacaoCompletaComSucesso() {
        docBase.criaElemento("Documento base", new Texto("Isso aqui é um texto", 3));
        assertEquals("Isso aqui é um texto", docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void textoRepresentacaoResumidaComSucesso() {
        docBase.criaElemento("Documento base", new Texto("Isso aqui é um texto", 3));
        assertEquals("Isso aqui é um texto", docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void tituloLinkavelRepresentacaoCompletaComSucesso() {
        docBase.criaElemento("Documento base", new Titulo("Isso aqui é um titulo", 3,
                1, true));
        assertEquals("1. Isso aqui é um titulo --\n1-ISSOAQUIÉUMTITULO",
                docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void tituloLinkavelRepresentacaoResumidaComSucesso() {
        docBase.criaElemento("Documento base", new Titulo("Isso aqui é um titulo", 3,
                1, true));
        assertEquals("1. Isso aqui é um titulo",
                docBase.representacaoResumida("Documento base", 0));
    }

    @Test
    public void tituloNaoLinkavelRepresentacaoCompletaComSucesso() {
        docBase.criaElemento("Documento base", new Titulo("Isso aqui é um titulo", 3,
                1, false));
        assertEquals("1. Isso aqui é um titulo",
                docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void tituloNaoLinkavelRepresentacaoResumidaComSucesso() {
        docBase.criaElemento("Documento base", new Titulo("Isso aqui é um titulo", 3,
                1, false));
        assertEquals("1. Isso aqui é um titulo",
                docBase.representacaoResumida("Documento base", 0));
    }

    @Test
    public void listaRepresentacaoCompleta() {
        // Caracteres de escape no separador pois java considera o pipe como caractere especial.

        docBase.criaElemento("Documento base", new Lista("Exemplo | de uma lista | de 3 termos",
                3, "\\|", "-"));
        assertEquals("- Exemplo\n- de uma lista\n- de 3 termos\n",
                docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void listaRepresentacaoResumida() {
        // Caracteres de escape no separador pois java considera o pipe como caractere especial.

        docBase.criaElemento("Documento base", new Lista("Exemplo ~ de uma lista ~ de 3 termos",
                3, "~", "-"));
        assertEquals("Exemplo~ de uma lista~ de 3 termos",
                docBase.representacaoResumida("Documento base", 0));
    }

    @Test
    public void termosRepresentacaoCompletaSemOrdenacao() {
        docBase.criaElemento("Documento base", new Termo("Teste/termos/Aleatorios", 3, "/", "NENHUM"));

        assertEquals("Total termos: 3\n- Teste, termos, Aleatorios",
                docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void termosRepresentacaoResumidaSemOrdenacao() {
        docBase.criaElemento("Documento base", new Termo("Teste/termos/Aleatorios", 3, "/", "NENHUM"));

        assertEquals("Teste / termos / Aleatorios",
                docBase.representacaoResumida("Documento base", 0));
    }

    @Test
    public void termosRepresentacaoCompletaOrdenadaAlfabeticamente() {
        docBase.criaElemento("Documento base", new Termo("Teste/termos/Aleatorios", 3, "/", "ALFABETICA"));

        assertEquals("Total termos: 3\n- Aleatorios, termos, Teste",
                docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void termoRepresentacaoCompletaOrdenadoPorTamanho() {
        docBase.criaElemento("Documento base", new Termo("Teste/termos/Aleatorios", 3, "/", "TAMANHO"));

        assertEquals("Total termos: 3\n- Aleatorios, termos, Teste",
                docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void termoRepresentacaoCompletaPalavrasMesmoTamanho() {
        docBase.criaElemento("Documento base", new Termo("Testes/termos/Aleatorios", 3, "/", "TAMANHO"));

        assertEquals("Total termos: 3\n- Aleatorios, Testes, termos",
                docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void termoRepresentacaoResumidaOrdenadoPorTamanho() {
        docBase.criaElemento("Documento base", new Termo("Teste/termos/Aleatorios", 3, "/", "TAMANHO"));

        assertEquals("Aleatorios / termos / Teste",
                docBase.representacaoResumida("Documento base", 0));
    }

    /* Teste para atalhos */

    @Test
    public void criandoAtalhoComSucesso() throws IllegalAccessException {
        docBase.criarDocumento("Doc atalho");
        docBase.criaElemento("Documento base", new Texto("Texto", 5));

        assertEquals(0, docBase.criarAtalho("Doc atalho", "Documento base"));
    }

    @Test
    public void criandoAtalhoDocumentoJaAtalhado() throws IllegalAccessException {
        docBase.criarDocumento("Doc atalho");
        docBase.criarDocumento("Doc novo");
        docBase.criaElemento("Documento base", new Texto("Texto", 5));

        docBase.criarAtalho("Doc atalho", "Documento base");

        assertThrows(IllegalStateException.class,
                () ->docBase.criarAtalho("Doc novo", "Documento base"));
    }

    @Test
    public void criandoAtalhoDocumentoJaEhAtalho() throws IllegalAccessException {
        docBase.criarDocumento("Doc atalho");
        docBase.criaElemento("Documento base", new Texto("Texto", 5));

        docBase.criarAtalho("Doc atalho", "Documento base");

        assertThrows(IllegalStateException.class,
                () ->docBase.criarAtalho("Doc atalho", "Documento base"));
    }

    /* Visão */

    @Test
    public void criandoVisaoCompletaComSucesso() {
        assertEquals(0, docBase.criarVisaoCompleta("Documento base"));
    }

    @Test
    public void criandoVisaoCompletaComDocumentoVazio() {
        assertThrows(IllegalArgumentException.class,
        () -> docBase.criarVisaoCompleta(""));
    }

    @Test
    public void criandoVisaoResumidaComSucesso() {
        assertEquals(0, docBase.criarVisaoResumida("Documento base"));
    }

    @Test
    public void criandoVisaoResumidaComDocumentoVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> docBase.criarVisaoResumida(""));
    }

    @Test
    public void criandoVisaoPrioritariaComSucesso() {
        assertEquals(0, docBase.criarVisaoPrioritaria("Documento base", 5));
    }

    @Test
    public void criandoVisaoPrioritariaComDocumentoVazio() {
        assertThrows(IllegalArgumentException.class,
        () -> docBase.criarVisaoPrioritaria("", 5));
    }

    @Test
    public void criandoVisaoPrioritariaComPrioridadeLimiteAbaixo() {
        assertEquals(0, docBase.criarVisaoPrioritaria("Documento base", 1));
    }

    @Test
    public void criandoVisaoPrioritariaComPrioridadeMaiorQueLimite() {
        assertThrows(IllegalArgumentException.class,
                () -> docBase.criarVisaoPrioritaria("Documento base", 6));
    }

    @Test
    public void criandoVisaoPrioritariaComPrioridadeMenorQueLimite() {
        assertThrows(IllegalArgumentException.class,
                () -> docBase.criarVisaoPrioritaria("Documento base", 0));
    }

    @Test
    public void criandoVisaoTitulo() {
        assertEquals(0, docBase.criarVisaoTitulo("Documento base"));
    }

    @Test
    public void criandoVisaoTituloComDocumentoVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> docBase.criarVisaoTitulo(""));
    }

    @Test
    public void exibirVisaoCompleta() {
        docBase.criarVisaoCompleta("Documento base");
        docBase.criaElemento("Documento base", new Texto("Texto basico", 4));
        docBase.criaElemento("Documento base", new Titulo("Teste de Visao", 4, 1, false));

        String[] expected = new String[] {"Texto basico", "1. Teste de Visao"};
        assertTrue(Arrays.equals(expected,docBase.exibirVisao(0)));
    }

    @Test
    public void exibirVisaoResumida() {
        docBase.criarVisaoResumida("Documento base");
        docBase.criaElemento("Documento base", new Texto("Texto basico", 4));
        docBase.criaElemento("Documento base", new Lista("Teste ~ para Visao ~ lab 5",
                3, "~", "-"));

        String[] expected = new String[] {"Texto basico", "Teste~ para Visao~ lab 5"};
        assertTrue(Arrays.equals(expected,docBase.exibirVisao(0)));
    }

    @Test
    public void exibirVisaoPrioritaria() {
        docBase.criarVisaoPrioritaria("Documento base", 4);
        docBase.criaElemento("Documento base", new Texto("Texto basico", 5));
        docBase.criaElemento("Documento base", new Texto("Texto basico", 3));
        docBase.criaElemento("Documento base", new Lista("Teste ~ para Visao ~ lab 5",
                4, "~", "-"));

        String[] expected = new String[] {"Texto basico", "- Teste\n- para Visao\n- lab 5\n"};
        assertArrayEquals(expected,docBase.exibirVisao(0));
    }

    @Test
    public void exibirVisaoTitulo() {
        docBase.criarVisaoTitulo("Documento base");
        docBase.criaElemento("Documento base", new Titulo("Titulo basico", 3, 1, false));
        docBase.criaElemento("Documento base", new Texto("Texto basico", 4));
        docBase.criaElemento("Documento base", new Lista("Teste ~ para Visao ~ lab 5",
                3, "~", "-"));

        String[] expected = new String[] {"1. Titulo basico"};
        assertArrayEquals(expected,docBase.exibirVisao(0));
    }

}
