package br.ufcg.teste;

import agenda.Agenda;
import static org.junit.jupiter.api.Assertions.*;

import agenda.Contato;
import org.junit.jupiter.api.*;

import java.util.InputMismatchException;

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
    void quandoPrecisoAdicionarContatoComSucesso() {

        // Posição limite abaixo.
        agendaBase.cadastraContato(1, "Winicius", "Allan", "8399630-3246");
        // Posição limite acima.
        agendaBase.cadastraContato(100, "John", "Doe", "(83) 2101-2101");
        agendaBase.cadastraContato(2, "Ouvidoria UFCG", "", "(83) 2102-2102");
    }

    @Test
    @DisplayName("Quando o nome for vazio")
    void quandoONomeForVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(2, // Nome vazio.
                        "", "Doe", "8395467-8976"));
    }

    @Test
    @DisplayName("Quando o nome for nulo")
    void quandoONomeForNulo() {
        assertThrows(NullPointerException.class,
                () -> agendaBase.cadastraContato(2, // Nome nulo.
                        null, "Doe", "(83) 99546-7876"));
    }

    @Test
    @DisplayName("Quando o sobrenome for nulo")
    void quandoOSobrenomeForNulo() {
        assertThrows(NullPointerException.class,
                () -> agendaBase.cadastraContato(2, // Sobrenome nulo.
                        "John", null, "(83) 99546-7876"));
    }

    @Test
    @DisplayName("Quando o telefone for nulo")
    void quandoOTelefoneForNulo() {
        assertThrows(NullPointerException.class,
                () -> agendaBase.cadastraContato(2,
                        "John", "Doe", null));
    }

    @Test
    @DisplayName("Quando o telefone for vazio")
    void quandoOTelefoneForVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.cadastraContato(2, // Telefone vazio.
                        "John", "Doe", ""));
    }

    @Test
    @DisplayName("Quando preciso cadastrar e a posição é inválida")
    void quandoAPosicaoEhInvalida() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.cadastraContato(0, // Posição abaixo do limite.
                        "Matheus", "Gaudencio", "(83) 99999-0000"));

        assertThrows(IndexOutOfBoundsException.class,
                () -> agendaBase.cadastraContato(101, // Posição acima do limite.
                        "Matheus", "Gaudencio", "(83) 99999-0000"));
    }

    @Test
    @DisplayName("Quando o contato ja foi cadastrado")
    void quandoOCadastroJaFoiCadastrado() {
        agendaBase.cadastraContato(1, "Foo", "Bar", "21012101");

        assertThrows(InputMismatchException.class,
                () -> agendaBase.cadastraContato(2, "Foo", "Bar", "21022102"));
    }

    @Test
    @DisplayName("Quando eu preciso exibir um contato")
    void quandoPrecisoPegarUmContatoComSucesso() {
        agendaBase.cadastraContato(1, "Matheus", "Gaudencio", "(83) 2101-2101");
        agendaBase.getContato(1);
    }

    @Test
    @DisplayName("Quando preciso pegar contato e a posição é inválida")
    void quandoPrecisoPegarContatoEPosicaoInvalida() {
        assertThrows(ArrayIndexOutOfBoundsException.class, // Posição acima do limite.
                () -> agendaBase.getContato(101));

        assertThrows(ArrayIndexOutOfBoundsException.class, // Posição abaixo do mínimo.
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
    @DisplayName("Quando eu preciso adicionar um favorito com sucesso")
    void quandoPrecisoAdicionarFavoritoComSucesso() {
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");
        agendaBase.cadastraContato(2, "Matheus", "Gaudêncio", "21022102");

        agendaBase.adicionaFavorito(1, agendaBase.getContato(1)); // Posição MÍNIMA permitida.
        agendaBase.adicionaFavorito(10, agendaBase.getContato(2)); // Posição MÀXIMA permitida
    }

    @Test
    @DisplayName("Quando eu preciso adicionar favorito e a posição é inválida")
    void quandoPrecisoAdicionarFavoritoEPosicaoInvalida() {
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");
        agendaBase.cadastraContato(2, "Matheus", "Gaudêncio", "21022102");

        assertThrows(ArrayIndexOutOfBoundsException.class, // Posição acima do permitido
                () -> agendaBase.adicionaFavorito(11, agendaBase.getContato(1)));

        assertThrows(ArrayIndexOutOfBoundsException.class, // Posição abaixo do permitido
                () -> agendaBase.adicionaFavorito(0, agendaBase.getContato(1)));
    }

    @Test
    @DisplayName("Quando preciso adicionar favorito e contato já favoritado")
    void quandoPrecisoAdicionaFavoritoEContatoJaFavoritado() {
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");
        agendaBase.adicionaFavorito(1, agendaBase.getContato(1));

        assertThrows(IllegalArgumentException.class, // Contato já favoritado.
                () -> agendaBase.adicionaFavorito(1, agendaBase.getContato(1)));
    }

    @Test
    @DisplayName("Quando eu preciso remover um favorito")
    void quandoPrecisoRemoverFavoritoComSucesso() {
        // Act
        agendaBase.cadastraContato(1, "John", "Doe", "21012101");
        Contato contato = agendaBase.getContato(1);
        agendaBase.adicionaFavorito(1, contato);

        agendaBase.removeFavorito(1);
        assertNull(agendaBase.getFavoritos()[1]); // Favorito null nessa posição
    }

    @Test
    @DisplayName("Quando preciso remover favorito e o índice é inválido")
    void quandoPrecisoRemoverFavoritoEIndiceInvalido() {
        assertThrows(ArrayIndexOutOfBoundsException.class, // Índice inválido.
                () -> agendaBase.removeFavorito(11));

        assertThrows(ArrayIndexOutOfBoundsException.class, // Índice inválido.
                () -> agendaBase.removeFavorito(0));
    }

    @Test
    @DisplayName("Quando preciso remover favorito e o contato já não é favoritado")
    void quandoPrecisoRemoverFavoritoEJaNaoEhFavorito() {
        assertThrows(IllegalArgumentException.class,
                () -> agendaBase.removeFavorito(1)); // Contato já não está nos favoritos.
    }

    @Test
    @DisplayName("Quando eu preciso exibir um contato favoritado")
    void QuandoPrecisoPegarContatosFavorito() {
        agendaBase.cadastraContato(1, "Matheus", "Gaudêncio", "(83) 21012101");
        agendaBase.cadastraContato(2, "John", "Doe", "(83) 996303247");
        Contato contato1 = agendaBase.getContato(1);
        Contato contato2 = agendaBase.getContato(2);

        agendaBase.adicionaFavorito(1, contato1);
        agendaBase.adicionaFavorito(2, contato2);

        Contato[] expected = new Contato[10]; // Contato semelhante ao esperado.
        expected[0] = contato1; expected[1] = contato2;

        Contato[] favoritos = agendaBase.getFavoritos();
        assertArrayEquals(expected, favoritos);
    }
}
