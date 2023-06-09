package DocuMin.testes;

import DocuMin.controllers.DocumentoController;
import DocuMin.entities.*;
import org.junit.Before;
import org.junit.Test;

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
    public void termoRepresentacaoCompletaOrdenadoPorTamanho() {
        docBase.criaElemento("Documento base", new Termo("Teste/termos/Aleatorios", 3, "/", "TAMANHO"));

        System.out.println(docBase.representacaoCompleta("Documento base", 0));
    }

    @Test
    public void termoRepresentacaoResumidaOrdenadoPorTamanho() {
        docBase.criaElemento("Documento base", new Termo("Teste/termos/Aleatorios", 3, "/", "TAMANHO"));

        System.out.println(docBase.representacaoResumida("Documento base", 0));
    }
}
