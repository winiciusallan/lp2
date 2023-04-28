package mr.bet;

import java.util.ArrayList;
import java.util.HashMap;

public class MrBetController {

    private ArrayList<Campeonato> campeonatos;
    private HashMap<String, Time> times;
    public MrBetController() {
        campeonatos = new ArrayList<>();
        times = new HashMap<>();
    }

    public ArrayList<Campeonato> getCampeonatos() { return campeonatos; }

    public HashMap<String, Time> getTimes() { return times; }

    public boolean incluirTime(String nome, String codigo, String mascote) {
        Time time = new Time(nome, codigo.toUpperCase(), mascote);

        if (!jaExisteTime(time)) {
            times.put(codigo, time);
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Time recuperarTime(String codigo) {
       for (String iCodigo : times.keySet()) {
           if (iCodigo.equals(codigo.toUpperCase())) { return times.get(codigo); }
       }
       if (times.get(codigo) == null) {
           throw new IllegalArgumentException();
       }
       return null;
    }

    private boolean jaExisteTime(Time time) {
        for (Time iTime : times.values()) {
            if (iTime == null) { return false; }
            if (iTime.equals(time)) { return true; }
        }
        return false;
    }
}
