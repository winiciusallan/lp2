package mr.bet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representação do controlador do sistema com todas as funcionalidades necessárias para inserir time, campeonato,
 * criação de apostas, entre outros.
 * @author Winicius Allan
 */
public class MrBetController {
    /**
     * Repositório onde será armazenado os times, campeonatos e apostas.
     */
    private MrBetRepository mrBetRepository;

    /**
     * Cria o controlador.
     */
    public MrBetController() {
        mrBetRepository = new MrBetRepository();
    }

    /**
     * Inclui time no repositório, armazenando-o em um vetor. Caso o time já existe, não será cadastrado.
     * @param nome Nome do time.
     * @param codigo Código identificador do time.
     * @param mascote Mascote do time.
     * @return Um valor lógico. Se foi adicionado com sucesso retorna true, se não, retorna falso
     */
    public boolean incluirTime(String nome, String codigo, String mascote) {
        Time time = new Time(nome, codigo.toUpperCase(), mascote);

        if (!jaExisteTime(codigo)) {
            mrBetRepository.incluirTime(time, codigo.toUpperCase());
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Recupera o time de acordo com o identificador passado.
     * @param codigo Código do time.
     * @return O time que der match com o identificador.
     */
    public Time recuperarTime(String codigo) {;
        for (String iCodigo : mrBetRepository.getTimes().keySet()) {
           if (codigo.toUpperCase().equals(iCodigo)) { return mrBetRepository.getTime(codigo.toUpperCase()); }
        }
        if (mrBetRepository.getTime(codigo) == null) {
           throw new IllegalArgumentException();
        }
        return null;
    }

    /**
     * Adiciona um campeonato no repositório. Caso o campeonato já existe, não será adicionado.
     * @param nome Nome do campeonato
     * @param participantes Número de partipantes do campeonato.
     * @return Um valor lógico. Se foi adicionado com sucesso retorna true, se não, retorna falso
     */
    public boolean adicionarCampeonato(String nome, int participantes) {
        Campeonato camp = new Campeonato(nome, participantes);

        if (!jaExisteCampeonato(camp)) {
            mrBetRepository.adicionarCampeonato(camp);
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Adiciona um time em um campeonato no repositório. Caso o time não existe, não será adicionado. Caso o campeonato
     * não existe, não será adicionado.
     * @param codigo Código do time o qual será adicionado.
     * @param nomeCampeonato Nome do campeonato em que o time será adicionado.
     * @return Um valor lógico. True se tiver adicionado com sucesso. Caso não, uma exceção será jogada.
     */
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

    /**
     * Faz a verificação se, no repositório, um time está contido ou não em um campeonato.
     * @param codigo Código do time que será verificado.
     * @param nomeDoCampeonato Nome do campeonato que será verificado
     * @return Um valor lógico indicando se o time está contido no campeonato ou não.
     */
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

    /**
     * Faz a exibição de todos os campeonatos que um time participa.
     * @param codigo Código do time que será mostrado os campeonatoss
     * @return Uma String com a representação textual dos respectivos campeonatos.
     */
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

    /**
     * Realiza uma aposta e armazena ela no repositório. A aposta contem informações do time, campeonato apostado,
     * sua colocação e o valor da aposta.
     * @param codigo Código do time.
     * @param campeonato Nome do campeonato.
     * @param colocacao Colocação que o time ficará.
     * @param valorDaAposta O valor que será apostado.
     * @return Um valor lógico indicando se a aposta foi realizada com sucesso ou não.
     */
    public boolean apostar(String codigo, String campeonato, int colocacao, double valorDaAposta) {

        if (!jaExisteCampeonato(campeonato)) {
            throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE");
        }
        Campeonato camp = mrBetRepository.getCampeonato(campeonato);
        if (colocacao > camp.getTimes().length) {
            throw new IllegalArgumentException("APOSTA NÃO REGISTRADA");
        }

        if (!jaExisteTime(codigo)) {
            throw new IllegalArgumentException("TIME NÃO EXISTE");
        }
        Aposta aposta = new Aposta(mrBetRepository.getTime(codigo), camp, colocacao, valorDaAposta);
                                mrBetRepository.adicionaAposta(aposta);
        return true;
    }

    /**
     * Exibe o status de todas as apostas contidas no repositório. Mostrando o time, campeonato, colocação e valor
     * apostado pelo usuário.
     * @return Uma representação textual de todas as apostas contidas no repositório.
     */
    public String statusApostas() {
        String output = "";
        int i = 0;
        for (Aposta aposta : mrBetRepository.getApostas()) {
            output += "\n" + (i + 1) + ". " + aposta + "\n";
            i++;
        }
        return output;
    }
    private boolean jaExisteTime(String id) {
        return mrBetRepository.getTimes().containsKey(id.toUpperCase());
    }

    private boolean jaExisteCampeonato(Campeonato camp) {
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
