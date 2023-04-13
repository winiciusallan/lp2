package br.ufcg.teste;

import agenda.Agenda;
import static org.junit.jupiter.api.Assertions.*;

import agenda.Contato;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AgendaTest {

    private static Agenda agendaBase;

    @BeforeAll
    static void criaAgenda() {
        agendaBase = new Agenda();
    }

    @Test
    void testCadastraContato() {
        agendaBase.cadastraContato(1, "Winicius", "Allan", "8399630-3246");
        Contato test1 = agendaBase.getContato(1);

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> agendaBase.cadastraContato(101, "Eliane", "Araújo", "832101-2101"));

        assertEquals(agendaBase.getContato(1), test1);
    }
}
