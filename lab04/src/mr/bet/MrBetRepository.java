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

    private ArrayList<Aposta> apostas;

    public MrBetRepository() {
        campeonatos = new ArrayList<>();
        times = new HashMap<>();
        apostas = new ArrayList<>();
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

    public ArrayList<Aposta> getApostas() { return apostas; }

    public void incluirTime(Time time, String id) {
        times.put(id, time);
    }

    public void adicionarCampeonato(Campeonato camp) {
        campeonatos.add(camp);
    }

    public void incluirTimeEmCampeonato(Time time, Campeonato campeonato) {
        for (int i = 0; i < campeonato.getTimes().length; i++) {
            if (campeonato.getTimes()[i] == null) {
                campeonato.getTimes()[i] = time;
                return;
            }
        }
        throw new IndexOutOfBoundsException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUIDOS!");
    }

    public void adicionaAposta(Aposta aposta) {
        apostas.add(aposta);
    }
}
