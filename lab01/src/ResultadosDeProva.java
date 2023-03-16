import java.util.Scanner;

public class ResultadosDeProva {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] alunos;
        int soma = 0; int menor = 1000; int maior = 0; int acima = 0; int abaixo = 0;
        double media = 0; int quantAlunos = 0;

        while (true) {
            alunos = input.nextLine().split(" ");

            if (alunos[0].equals("-")) { break; }

            int nota = Integer.parseInt(alunos[1]);

            if (nota > maior) { maior = nota; }
            if (nota < menor) { menor = nota; }

            quantAlunos++; // Quantidade de notas lidas
            soma += nota;
            media = soma / quantAlunos;

            if (nota < 700) { abaixo++; }
            if (nota >= 700) { acima++; }
        }

        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + (int) media);
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + abaixo);
    }
}

