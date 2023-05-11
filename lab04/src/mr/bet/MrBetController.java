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

    public boolean verificarTimeEmCampeonato(String codigo, String nomeDoCampeonato) {
        if (!jaExisteTime(codigo)) {
            throw new IllegalArgumentException("TIME NÃO EXISTE");
        }
        else if (!jaExisteCampeonato(nomeDoCampeonato)) {
            throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE");
        }
        Time time = mrBetRepository.getTime(codigo);
        Campeonato camp = mrBetRepository.getCampeonato(nomeDoCampeonato);

        for (Time iTime : camp.getTimes()) {
            if (iTime == null) { return false; }
            if (iTime.equals(time)) { return true; }
        }
        return false;
    }

    public String exibirCampeonatosTimeParticipa(String codigo) {
        if (!jaExisteTime(codigo)) {
            throw new IllegalArgumentException("TIME NÃO EXISTE");
        }
        Time time = mrBetRepository.getTime(codigo);
        String output = "Campeonatos do " + time.getNome() + ":";

        for (Campeonato camp : mrBetRepository.getCampeonatos()) {
            if (camp.containsTime(time)) {
                output += "\n* " + camp.getNome() + " - " +
                        String.format("%d/%d", camp.contaTime(), camp.getTimes().length) ;
            }
        }

        return output;
    }

    public boolean apostar(String codigo, String campeonato, int colocacao, double valorDaAposta) {
        // Implementar casos de erro
        Campeonato camp = mrBetRepository.getCampeonato(campeonato);
        if (colocacao > camp.getTimes().length) {
            throw new IllegalArgumentException("APOSTA NÃO REGISTRADA");
        }
        if (!jaExisteTime(codigo)) {
            throw new IllegalArgumentException("TIME NÃO EXISTE");
        }
        if (!jaExisteCampeonato(campeonato)) {
            throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE");
        }

        Aposta aposta = new Aposta(mrBetRepository.getTime(codigo), camp, colocacao, valorDaAposta);
        mrBetRepository.adicionaAposta(aposta);
        return true;
    }

    public String statusApostas() {
        String output = "";
        int i = 0;
        for (Aposta aposta : mrBetRepository.getApostas()) {
            output += "\n" + (i + 1) + aposta + "\n";
            i++;
        }
        return output;
    }
    private boolean jaExisteTime(String id) {
//        for (String iCodigo : mrBetRepository.getTimes().keySet()) { // Compara o id com os hashs da estrutura de dado.
//            if (iCodigo.equals(id.toUpperCase())) { return true; }
//        }
        return mrBetRepository.getTimes().containsKey(id.toUpperCase());
    }

    private boolean jaExisteCampeonato(Campeonato camp) {
//        for (Campeonato iCamp : mrBetRepository.getCampeonatos()) {
//            if (iCamp.equals(camp)) { return true; }
//        }

        return mrBetRepository.getCampeonatos().contains(camp);
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
