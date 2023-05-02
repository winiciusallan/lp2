package mr.bet;

import java.util.ArrayList;
import java.util.HashMap;

public class MrBetController {

    private MrBetRepository mrBetRepository;

    public MrBetController() {
        mrBetRepository = new MrBetRepository();
    }

    public boolean incluirTime(String nome, String codigo, String mascote) {
        Time time = new Time(nome, codigo.toUpperCase(), mascote);

        if (!jaExisteTime(codigo)) {
            mrBetRepository.incluirTime(time, codigo.toUpperCase());
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Time recuperarTime(String codigo) {;
        for (String iCodigo : mrBetRepository.getTimes().keySet()) {
           if (codigo.toUpperCase().equals(iCodigo)) { return mrBetRepository.getTime(codigo.toUpperCase()); }
        }
        if (mrBetRepository.getTime(codigo) == null) {
           throw new IllegalArgumentException();
        }
        return null;
    }

    public boolean adicionarCampeonato(String nome, int participantes) {
        Campeonato camp = new Campeonato(nome, participantes);

        if (!jaExisteCampeonato(camp)) {
            mrBetRepository.adicionarCampeonato(camp);
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean incluirTimeEmCampeonato(String codigo, String nomeCampeonato) {
        if (!jaExisteTime(codigo)) {
            throw new IllegalArgumentException("TIME NÃO EXISTE");
        }
        else if (!jaExisteCampeonato(nomeCampeonato)) {
            throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE");
        }
        else {
            Time time = mrBetRepository.getTime(codigo);
            Campeonato camp = mrBetRepository.getCampeonato(nomeCampeonato);

            mrBetRepository.incluirTimeEmCampeonato(time, camp);
            return true;
        }
    }
    private boolean jaExisteTime(String id) {
        for (String iCodigo : mrBetRepository.getTimes().keySet()) { // Compara o id com os hashs da estrutura de dado.
            if (iCodigo.equals(id.toUpperCase())) { return true; }
        }
        return false;
    }

    private boolean jaExisteCampeonato(Campeonato camp) {
        for (Campeonato iCamp : mrBetRepository.getCampeonatos()) {
            if (iCamp.equals(camp)) { return true; }
        }

        return false;
    }

    private boolean jaExisteCampeonato(String nomeCamp) {
        for (Campeonato iCamp : mrBetRepository.getCampeonatos()) {
            if (iCamp.getNome().toUpperCase().equals(nomeCamp.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
