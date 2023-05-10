package laboratorio4.teste;

import mr.bet.MrBetRepository;
import org.junit.Test;
import mr.bet.MrBetController;
import mr.bet.Time;
//import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class MrBetControllerTest {

    private static MrBetController mrBetBase;
    private static Time timeBase;

    @Before
    public void setUp() {
        mrBetBase = new MrBetController();
        mrBetBase.incluirTime("Campinense", "110_PB", "Raposa");
    }

    @Test
    @DisplayName("Quando eu preciso incluir um time com sucesso")
    public void quandoPrecisoIncluirTimeSucesso() {
        MrBetController mrBetBase = new MrBetController();
        assertTrue(mrBetBase.incluirTime("Treze", "250_PB", "Galo"));
    }

    @Test
    @DisplayName("Quando eu preciso incluir time já existente")
    public void quandoPrecisoIncluirTimeJaExistente() {
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.incluirTime("Treze", "110_PB", "Galo"));
    }

    @Test
    @DisplayName("Quando eu preciso recuperar um time com sucesso")
    public void quandoPrecisoRecuperarTimeSucesso() {
        Time underTest = mrBetBase.recuperarTime("110_pb");
        assertTrue(underTest instanceof Time);
    }

    @Test
    @DisplayName("Quando recupero um time que não existe")
    public void quandoRecuperoTimeInexistente() {
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.recuperarTime("120_pb"));
    }

    @Test
    @DisplayName("Quando preciso adicionar um campeonato com sucesso")
    public void quandoPrecisoAdicionarCampeonatoSucesso() {
        assertTrue(mrBetBase.adicionarCampeonato("Brasileirão Série A 2023", 20));
    }

    @Test
    @DisplayName("Quando adiciono um campeonato que já existe")
    public void quandoAdicionoCampeonatoQueJaExiste() {
        mrBetBase.adicionarCampeonato("Brasileirão Série A 2023", 20);
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.adicionarCampeonato("Brasileirão Série A 2023", 20));
    }

    @Test
    @DisplayName("Quando adiciono um campeonato que já existe sem case sensitive")
    public void quandoAdicionoCampeonatoSemCaseSensitive() {
        mrBetBase.adicionarCampeonato("Brasileirão Série A 2023", 30);
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.adicionarCampeonato("brasiLeirão Série a 2023", 20));
    }

    @Test
    @DisplayName("Quando preciso incluir um time em um campeonato com sucesso")
    public void quandoPrecisoIncluirTimeEmCampeonatoSucesso() {
        mrBetBase.adicionarCampeonato("Paraibano 2023", 2);
        mrBetBase.incluirTimeEmCampeonato("110_pb", "Paraibano 2023");
    }

    @Test
    @DisplayName("Quando preciso incluir um time em um campeonato com sucesso em minusculo")
    public void quandoPrecisoIncluirTimeEmCampeonatoSucessoMinusculo() {
        mrBetBase.adicionarCampeonato("Paraibano 2023", 2);
        mrBetBase.incluirTimeEmCampeonato("110_pb", "paraIbanO 2023");
    }

    @Test
    @DisplayName("Quando preciso incluir um time que não existe em um campeonato")
    public void quandoPrecisoIncluirTimeQueNaoExiste() {
        mrBetBase.adicionarCampeonato("Paraibano 2023", 5);
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.incluirTimeEmCampeonato("250_pb", "paraibano 2023"));
    }

    @Test
    @DisplayName("Quando preciso incluir um time em um campeonato que não existe")
    public void incluirTimeCampeonatoNaoExiste() {
        mrBetBase.adicionarCampeonato("Brasileirao 2022", 10);
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.incluirTimeEmCampeonato("110_pb", "Brasileirao 2023"));
    }

    @Test
    @DisplayName("Quando preciso incluir time em campeonato que já ultrapassou participantes")
    public void incluirTimeEmCampeonatoQueParticipantesEstaCheio() {
        mrBetBase.adicionarCampeonato("Brasileirao 2023", 2);
        mrBetBase.incluirTime("Treze", "120_pb", "Galo");
        mrBetBase.incluirTime("Nacional de Patos", "130_pb", "Canario");
        mrBetBase.incluirTime("Sport", "140_pe", "Canario");

        mrBetBase.incluirTimeEmCampeonato("120_pb", "brasileirao 2023");
        mrBetBase.incluirTimeEmCampeonato("130_pb", "brasileirao 2023");
        assertThrows(IndexOutOfBoundsException.class,
                () -> mrBetBase.incluirTimeEmCampeonato("140_pe", "brasileirao 2023"));
    }

    @Test
    @DisplayName("Quando preciso verificar se um time está em um campeonato com sucesso")
    public void verificarSeTimeEstaEmCampeonatoComSucesso() {
        mrBetBase.adicionarCampeonato("Brasileirao 2023", 2);
        mrBetBase.incluirTimeEmCampeonato("110_pb", "brasileirao 2023");

        assertTrue(mrBetBase.verificarTimeEmCampeonato("110_pb", "brasileirao 2023"));
    }

    @Test
    @DisplayName("Quando preciso verificar se um time não está em um campeonato com sucesso")
    public void verificarSeTimeNaoEstaEmCampeonatoComSucesso() {
        mrBetBase.adicionarCampeonato("Brasileirao 2023", 2);

        assertFalse(mrBetBase.verificarTimeEmCampeonato("110_pb", "brasileirao 2023"));
    }

    @Test
    @DisplayName("Quando preciso verificar se um time está em um campeonato que não existe")
    public void verificarSeTimeEstaEmCampeonatoQueNaoExiste() {
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.verificarTimeEmCampeonato("110_pb", "paraibano 2025"));
    }

    @Test
    @DisplayName("Quando preciso verificar se um time que não existe está em um campeonato")
    public void verificarSeUmTimeQueNaoExisteEstaEmCampeonato() {
        mrBetBase.adicionarCampeonato("Brasileirao 2024", 5);

        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.verificarTimeEmCampeonato("120_pb", "brasileirao 2024"));
    }

    @Test
    @DisplayName("Quando preciso exibir com sucesso os campeonatos que um time participa")
    public void exibirOsCampeonatosDeUmTimeComSucesso() {
        mrBetBase.adicionarCampeonato("Brasileirao 2023", 10);
        mrBetBase.incluirTimeEmCampeonato("110_PB", "brasileirao 2023");

        System.out.println(mrBetBase.exibirCampeonatosTimeParticipa("110_pb"));
    }

    @Test
    @DisplayName("Se a saída do nome do campeonato é exatamente o cadastrado")
    public void verificarSeONomeDoCampeonatoEhOMesmo() {
        mrBetBase.adicionarCampeonato("BrAsilEirÃo 2023", 10);
        mrBetBase.incluirTimeEmCampeonato("110_pb", "brasileirão 2023");

        System.out.println(mrBetBase.exibirCampeonatosTimeParticipa("110_pb"));
    }
    @Test
    @DisplayName("Quando preciso exibir um time que não está cadastrado")
    public void exibirTimeQueNaoEstaCadastrado() {
        mrBetBase.adicionarCampeonato("Brasileirao 2023", 10);

        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.incluirTimeEmCampeonato("120_PB", "brasileirao 2023"));

    }
}
