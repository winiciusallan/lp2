package hughs.and.smiles;

public class HughsAndSmiles {

    private DogHost[] tutores;
    private Dog[] dogs;

    public HughsAndSmiles() {
    }

    public void adicionaDogHost(String nome, int qtdDogs, double qntRacao) {
        DogHost dogHost = new DogHost(nome, qtdDogs, qntRacao);

        for (int i = 0; i < tutores.length; i++) {
            if (tutores[i] == null) {
                tutores[i] = dogHost;
            }
        }
    }

    public boolean adicionaDog (String nome, String tutor. int qtdRacao){
        Dog dog
    }
}
