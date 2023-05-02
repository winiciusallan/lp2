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
}
