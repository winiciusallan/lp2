package hughs.and.smiles;

public class DogHost {

    private String nome;
    private Dog[] dogs;
    private int racaoMaximaDiaria;

    public DogHost(String nome, int qtdDogs, int racaoMaximaDiaria) {
        this.nome = nome;
        this.dogs = new Dog[qtdDogs];
        this.racaoMaximaDiaria = racaoMaximaDiaria;
    }

    public String getNome() {
        return nome;
    }

    public Dog[] getDogs() {
        return dogs;
    }

    public Dog getDog(String nome) {
        for (Dog dog : dogs) {
            if (dog.getNome().equals(nome)) {
                return dog;
            }
        }
        return null;
    }

    public double getRacaoMaximaDiaria() {
        return racaoMaximaDiaria;
    }

    public boolean adicionaDog(String nome, String tutor, int qtdRacao) {
        Dog dog = new Dog(nome, tutor, qtdRacao);

        if (dog.getRacaoDiaria() > racaoMaximaDiaria || contaDogs() == dogs.length) {
            return false;
        }

        for (int i = 0; i < dogs.length; i++) {
            if (dogs[i] == null) {
                dogs[i] = dog;
                return true;
            }
        }
        return false;
    }

    public boolean adicionaDog(String nome, String tutor, int qtdRacao, String tipoRestricao) {
        Dog dog = new Dog(nome, tutor, qtdRacao, tipoRestricao);

        if (dog.getRacaoDiaria() > racaoMaximaDiaria || contaDogs() == dogs.length) {
            return false;
        }

        for (int i = 0; i < dogs.length; i++) {
            if (dogs[i] == null) {
                dogs[i] = dog;
                return true;
            }
        }
        return false;
    }

    public String listaDogs() {
        String output = getNome() + "\n";

        for (Dog dog : dogs) {
            output += dog + "\n";
        }
        return output;
    }

    public double consultaValorHospedagem(Dog toto, int dias) {
        if (!existeDog(toto)) {
            throw new IllegalArgumentException();
        }

        return (0.4 * toto.getRacaoDiaria()) * dias;
    }

    public int totalDiarioRacao() {
        int count = 0;
        for (Dog dog : dogs) {
            count += dog.getRacaoDiaria();
        }
        return count;
    }

    public double valorTotalHospedagemDiaria() {
        double count = 0;
        for (Dog dog : dogs) {
            count += consultaValorHospedagem(dog, 1);
        }
        return count;
    }

    private int contaDogs() {
        int count = 0;
        for (Dog dog : dogs) {
            if (dog != null) {
                count++;
            }
        }
        return count;
    }

    private boolean existeDog(Dog dog) {
        for (Dog cachorro : dogs) {
            if (cachorro == null) { return false; }
            if (cachorro.equals(dog)) { return true; }
        }
        return true;
    }
}
