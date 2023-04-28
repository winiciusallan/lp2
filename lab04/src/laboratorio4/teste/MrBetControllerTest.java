package laboratorio4.teste;

import mr.bet.MrBetController;
import mr.bet.Time;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class MrBetControllerTest {

    private static MrBetController mrBetBase;
    private static Time timeBase;

    @BeforeEach
    void setUp() {
        mrBetBase = new MrBetController();
        mrBetBase.incluirTime("Campinense", "110_PB", "Raposa");
    }

    @Test
    @DisplayName("Quando eu preciso incluir um time com sucesso")
    void quandoPrecisoIncluirTimeSucesso() {
        MrBetController mrBetBase = new MrBetController();
        assertTrue(mrBetBase.incluirTime("Treze", "250_PB", "Galo"));
    }

    @Test
    @DisplayName("Quando eu preciso incluir time já existente")
    void quandoPrecisoIncluirTimeJaExistente() {
        assertThrows(IllegalArgumentException.class,
                () -> mrBetBase.incluirTime("Treze", "110_PB", "Galo"));
    }
}
