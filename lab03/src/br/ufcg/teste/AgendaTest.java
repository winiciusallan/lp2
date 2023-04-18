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
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.cadastraContato(0, // Posição abaixo do limite.
                "Matheus", "Gaudencio", "(83) 99999-0000"));

        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.cadastraContato(101, // Posição acima do limite.
                "Matheus", "Gaudencio", "(83) 99999-0000"));

        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(2, // Nome vazio.
                "", "Doe", "8395467-8976"));

        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(2, // Número vazio.
                "John", "Doe", ""));

        assertThrows(Exception.class,
                () -> agendaBase.cadastraContato(3,  // Contato já cadastrado.
                "Winicius", "Allan", "8399654-2377"));

        agendaBase.cadastraContato(100, // Posição limite.
                "Matheus", "Gaudencio", "(83) 99999-0000");

        assertEquals(agendaBase.getContato(1), test1);
    }

    @Test
    @DisplayName("Quando eu preciso exibir um contato")
    void quandoPrecisoExibirContato() {
        agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 2101-2101");

        agendaBase.getContato(1);

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> agendaBase.getContato(101));

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> agendaBase.getContato(0));
    }
    @Test
    @DisplayName("Quando eu preciso pegar os contatos")
    void quandoPrecisoPegarOsContatos() {
        agendaBase.cadastraContato(1, "John", "Doe", "8399630-3246");
        agendaBase.cadastraContato(22, "Ouvidoria UFCG", "","832101-2101");
        agendaBase.cadastraContato(10, "Fábio", "Morais", "832303-2303");

        Contato[] contatos = agendaBase.getContatos();
        for (Contato contato : contatos) { // Mostrar no console os contatos cadastrados acima.
            if (contato != null) {
                System.out.println(contato);
            }
        }
    }

    @Test
    @DisplayName("Quando eu preciso adicionar um favorito")
    void quandoPrecisoAdicionarFavorito() {
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");
        agendaBase.cadastraContato(2, "Matheus", "Gaudêncio", "21022102");

        assertThrows(ArrayIndexOutOfBoundsException.class, // Posição acima do permitido
                () -> agendaBase.adicionaFavorito(11, agendaBase.getContato(1)));

        assertThrows(ArrayIndexOutOfBoundsException.class, // Posição abaixo do permitido
                () -> agendaBase.adicionaFavorito(0, agendaBase.getContato(1)));

        agendaBase.adicionaFavorito(1, agendaBase.getContato(1)); // Posição MÍNIMA permitida.

        assertThrows(IllegalArgumentException.class, // Contato já favoritado.
                () -> agendaBase.adicionaFavorito(1, agendaBase.getContato(1)));

        agendaBase.adicionaFavorito(10, agendaBase.getContato(2)); // Posição MÀXIMA permitida.
    }

    @Test
    @DisplayName("Quando eu preciso remover um favorito")
    void quandoPrecisoRemoverFavorito() {
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");
        Contato contato = agendaBase.getContato(1);

        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.removeFavorito(1)); // Contato já não está nos favoritos.

        agendaBase.adicionaFavorito(1, contato);

        assertThrows(NullPointerException.class, // Índice inválido.
                () -> agendaBase.removeFavorito(11));

        agendaBase.removeFavorito(1);


        assertNull(agendaBase.getFavoritos()[1]); // Favorito null nessa posição
    }
}
