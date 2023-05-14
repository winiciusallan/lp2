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

    /**
     * Um vetor que armazena todos os campeonatos do sistema.
     */
    private ArrayList<Campeonato> campeonatos;

    /**
     * Um mapa com todos os times do sistema. Cada time é identificado por um código.
     */
    private HashMap<String, Time> times;

    /**
     * Um vetor com todas as apostas do sistema.
     */
    private ArrayList<Aposta> apostas;

    /**
     * Cria o repositório. Todos os vetores e estruturas iniciam vazios.
     */
    public MrBetRepository() {
        campeonatos = new ArrayList<>();
        times = new HashMap<>();
        apostas = new ArrayList<>();
    }

    public ArrayList<Campeonato> getCampeonatos() { return campeonatos; }

    public Campeonato getCampeonato(String nome) {
        for (Campeonato iCamp : campeonatos) {
            if (iCamp.getNome().toUpperCase().equals(nome.toUpperCase())) { return iCamp; }
        }
        return null;
    }

    public HashMap<String, Time> getTimes() { return times; }

    public Time getTime(String key) { return times.get(key.toUpperCase()); }

    public ArrayList<Aposta> getApostas() { return apostas; }

    /**
     * Realiza a inclusão de um time no mapa.
     * @param time O time que será adicionado.
     * @param id O seu identificador.
     */
    public void incluirTime(Time time, String id) {
        times.put(id, time);
    }

    /**
     * Armazena um campeonato no vetor.
     * @param camp
     */
    public void adicionarCampeonato(Campeonato camp) {
        campeonatos.add(camp);
    }

    /**
     * Faz a inclusão de um time dentro do vetor de campeonato.
     * @param time O time que será adicionado.
     * @param campeonato O campeonato que o time será adicionado.
     */
    public void incluirTimeEmCampeonato(Time time, Campeonato campeonato) {
        for (int i = 0; i < campeonato.getTimes().length; i++) {
            if (campeonato.getTimes()[i] == null) {
                campeonato.getTimes()[i] = time;
                return;
            }
        }
        throw new IndexOutOfBoundsException("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUIDOS!");
    }

    /**
     * Adiciona uma aposta no vetor.
     * @param aposta A aposta que será adicionada.
     */
    public void adicionaAposta(Aposta aposta) {
        apostas.add(aposta);
    }
}
