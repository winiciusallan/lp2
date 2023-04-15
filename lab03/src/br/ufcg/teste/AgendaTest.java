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
        Contato contatoBase = new Contato("Matheus", "Gaudencio", "(83) 2101-2101");
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
        assertFalse(agendaBase.cadastraContato(0, // Posição abaixo do limite.
                "Matheus", "Gaudencio", "(83) 99999-0000"));
        assertFalse(agendaBase.cadastraContato(101, // Posição acima do limite.
                "Matheus", "Gaudencio", "(83) 99999-0000"));
        assertFalse(agendaBase.cadastraContato(2, // Nome vazio.
                "", "Doe", "8395467-8976"));
        assertFalse(agendaBase.cadastraContato(2, // Número vazio.
                "John", "Doe", ""));
        assertFalse(agendaBase.cadastraContato(3,  // Contato já cadastrado.
                "Winicius", "Allan", "8399654-2377"));
        assertTrue(agendaBase.cadastraContato(100, // Posição limite.
                "Matheus", "Gaudencio", "(83) 99999-0000"));

        assertEquals(agendaBase.getContato(1), test1);
    }

    @Test
    @DisplayName("Quando eu preciso exibir um contato")
    void quandoPrecisoExibirContato() {
        agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 2101-2101");
        Contato testContato = agendaBase.getContato(1);

        assertTrue(agendaBase.exibeContato(1));
        assertFalse(agendaBase.exibeContato(3)); // False se não houver contato.
        assertFalse(agendaBase.exibeContato(101)); // Posição inválida.

        agendaBase.adicionaFavorito(1, testContato);
        assertTrue(agendaBase.exibeContato(1)); // Deve mostrar o contato como favoritado.
    }
    @Test
    @DisplayName("Quando eu preciso pegar os contatos")
    void quandoPrecisoPegarOsContatos() {
        agendaBase.cadastraContato(1, "John", "Doe", "8399630-3246");
        agendaBase.cadastraContato(22, "Ouvidoria UFCG", "","832101-2101");
        agendaBase.cadastraContato(10, "Fábio", "Morais", "832303-2303");

        Contato[] contatos = agendaBase.getContatos();
        for (Contato contato : contatos) {
            if (contato != null) {
                System.out.println(contato);
            }
        }
    }

    @Test
    @DisplayName("Quando eu preciso adicionar um favorito")
    void quandoPrecisoAdicionarFavorito() {
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");

        assertTrue(agendaBase.adicionaFavorito(1, agendaBase.getContato(1)));
    }

    @Test
    @DisplayName("Quando eu preciso remover um favorito")
    void quandoPrecisoRemoverFavorito() {
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");
        Contato contato = agendaBase.getContato(1);

        assertFalse(agendaBase.removeFavorito(1)); // Contato já não está nos favoritos.
        assertTrue(agendaBase.adicionaFavorito(1, contato));
        assertTrue(agendaBase.removeFavorito(1));
    }
}
