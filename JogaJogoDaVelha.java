
import java.util.Random;
import java.util.Scanner;

public class JogaJogoDaVelha {

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao teste do Jogo da Velha!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite 1 para jogar ou 0 para sair: ");
        int opcao = scanner.nextInt();
        Random random = new Random();

        while (opcao != 0) {
            JogoDaVelha jogo = new JogoDaVelha();
            int tamanho = jogo.getTamanho();
            int i, j;   

            while (jogo.vencedor()
                    == 2) {
                i = random.nextInt(tamanho);
                j = random.nextInt(tamanho);
                try {
                    jogo.poePeca(i, j);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
//                System.out.println(jogo.toString());
            }

            if (jogo.vencedor()
                    == 1) {
                System.out.println("Jogador X venceu!");
            } else if (jogo.vencedor()
                    == -1) {
                System.out.println("Jogador O venceu!");
            } else {
                System.out.println("Empate!");
            }

            System.out.println(jogo.toString());
            System.out.println(
                    "Deseja jogar novamente? (1-sim, 0-nao): ");
            opcao = scanner.nextInt();
        }
    }
}
