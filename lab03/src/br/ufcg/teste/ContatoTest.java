package br.ufcg.teste;

import agenda.Contato;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContatoTest {

    private Contato contatoBase;

    @BeforeEach
    void prepararContato() {
        this.contatoBase = new Contato("Winicius", "Allan", "8399630-3246");
    }

    @Test
    void testEquals() {
        String msg = "Esperando comparar os contatos";
        assertEquals(contatoBase, new Contato("Winicius", "Allan", "839984567"));
        assertEquals(contatoBase, new Contato("   Winicius    ", "Allan", "839984567"));
        assertNotEquals(contatoBase, new Contato("Eliane", "Araújo", "83 21012101"));
    }

}
