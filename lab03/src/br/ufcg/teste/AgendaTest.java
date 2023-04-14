package br.ufcg.teste;

import agenda.Agenda;
import static org.junit.jupiter.api.Assertions.*;

import agenda.Contato;
import org.junit.jupiter.api.*;

public class AgendaTest {

    private static Agenda agendaBase;

    @BeforeEach
    void setUp() {
        agendaBase = new Agenda();
    }

    @AfterAll
    static void tearDown() {
        agendaBase = null;
    }

    @Test
    @DisplayName("Quando eu preciso adicionar um contato")
    void quandoPrecisoAdicionarContato() {
        // Act (ação)
        agendaBase.cadastraContato(1, "Winicius", "Allan", "8399630-3246");
        Contato test1 = new Contato("Winicius", "Allan", "8399630-3246");

        // Assert (verificação)
        assertFalse(() -> agendaBase.cadastraContato(101,
                        "Eliane", "Araújo",
                        "832101-2101"));

        assertEquals(agendaBase.getContato(1), test1);
    }
}
