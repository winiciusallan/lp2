package mr.bet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação de um repositório para o sistema Mr. Bet, armazenando os campeonatos cadastrados
 * e os respectivos times participantes.
 *
 * @author Winicius Allan
 */
public class MrBetRepository {

    private ArrayList<Campeonato> campeonatos;
    private HashMap<String, Time> times;

    public MrBetRepository() {
        campeonatos = new ArrayList<>();
        times = new HashMap<>();
    }

    public ArrayList<Campeonato> getCampeonatos() { return campeonatos; }

    public Campeonato getCampeonato(int pos) { return campeonatos.get(pos); }

    public Campeonato getCampeonato(String nome) {
        for (Campeonato iCamp : campeonatos) {
            if (iCamp.getNome().toUpperCase().equals(nome.toUpperCase())) { return iCamp; }
        }
        return null;
    }

    public HashMap<String, Time> getTimes() { return times; }

    public Time getTime(String key) { return times.get(key.toUpperCase()); }

    public void incluirTime(Time time, String id) {
        times.put(id, time);
    }

    public void adicionarCampeonato(Campeonato camp) {
        campeonatos.add(camp);
    }

    public void incluirTimeEmCampeonato(Time time, Campeonato campeonato) {
        campeonato.adicionaTime(time);
    }
}
