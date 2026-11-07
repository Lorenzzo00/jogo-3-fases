
import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {

    static Scanner entrada = new Scanner(System.in);

    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Integer> pontos = new ArrayList<>();

    public static int lerNumero() {
        while (true) {
            try {
                return Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                System.out.println("Digite apenas numeros!");
            }
        }
    }

    public static int pergunta(String texto, String a, String b,
                               String c, int correta) {

        System.out.println("\n" + texto);
        System.out.println("1 - " + a);
        System.out.println("2 - " + b);
        System.out.println("3 - " + c);

        System.out.print("Sua resposta: ");
        int resposta = lerNumero();

        if (resposta == correta) {
            System.out.println("Resposta correta! +15 pontos");
            return 15;
        } else {
            System.out.println("Resposta errada!");
            return 0;
        }
    }

    public static void ranking() {

        // Organizar do maior para o menor

        for (int i = 0; i < pontos.size(); i++) {
            for (int j = i + 1; j < pontos.size(); j++) {

                if (pontos.get(j) > pontos.get(i)) {

                    int p = pontos.get(i);
                    pontos.set(i, pontos.get(j));
                    pontos.set(j, p);

                    String n = nomes.get(i);
                    nomes.set(i, nomes.get(j));
                    nomes.set(j, n);
                }
            }
        }

        System.out.println("\n===== RANKING =====");

        for (int i = 0; i < nomes.size(); i++) {
            System.out.println((i + 1) + " lugar: "
                    + nomes.get(i) + " - "
                    + pontos.get(i) + " pontos");
        }

        System.out.println("===================");
    }

    public static void main(String[] args) {

        int jogar = 1;

        while (jogar == 1) {

            int total = 0;

            System.out.println("\n======================");
            System.out.println("     JOGO DE 3 FASES");
            System.out.println("======================");

            System.out.print("Digite seu nome: ");
            String nome = entrada.nextLine();

            boolean passou = true;

            // FASE 1

            System.out.println("\n===== FASE 1 =====");
            System.out.println("PEDRA, PAPEL E TESOURA");
            System.out.println("Melhor de 3!");

            int vitorias = 0;
            int derrotas = 0;

            for (int i = 1; i <= 3; i++) {

                if (vitorias == 2 || derrotas == 2) {
                    break;
                }

                System.out.println("\nRodada " + i);
                System.out.println("1 - Pedra");
                System.out.println("2 - Papel");
                System.out.println("3 - Tesoura");

                System.out.print("Escolha: ");
                int jogador = lerNumero();

                if (jogador < 1 || jogador > 3) {
                    System.out.println("Opcao invalida!");
                    i--;
                    continue;
                }

                int computador = (int)(Math.random() * 3) + 1;

                System.out.println("Computador escolheu: " +
                        (computador == 1 ? "Pedra" :
                        computador == 2 ? "Papel" : "Tesoura"));

                if (jogador == computador) {
                    System.out.println("Empate!");
                } else if (
                    (jogador == 1 && computador == 3) ||
                    (jogador == 2 && computador == 1) ||
                    (jogador == 3 && computador == 2)
                ) {
                    System.out.println("Voce venceu!");
                    vitorias++;
                    total += 15;
                } else {
                    System.out.println("Voce perdeu!");
                    derrotas++;
                }
            }

            if (vitorias < 2) {
                System.out.println("\nVoce foi eliminado!");
                passou = false;
            } else {
                System.out.println("\nParabens! Passou para a fase 2!");
            }

            // FASE 2

            if (passou) {

                System.out.println("\n===== FASE 2 =====");
                System.out.println("PERGUNTAS SOBRE JAVA");

                int acertos = 0;

                acertos += pergunta(
                    "1) Para que serve o Scanner?",
                    "Fazer calculos",
                    "Ler dados do usuario",
                    "Criar imagens", 2);

                acertos += pergunta(
                    "2) Qual comando mostra algo na tela?",
                    "System.out.println",
                    "Scanner",
                    "int", 1);

                acertos += pergunta(
                    "3) Qual tipo de variavel guarda numeros inteiros?",
                    "String",
                    "int",
                    "boolean", 2);

                acertos += pergunta(
                    "4) Qual comando verifica uma condicao?",
                    "if",
                    "print",
                    "Scanner", 1);

                acertos += pergunta(
                    "5) Qual estrutura serve para repetir comandos?",
                    "String",
                    "double",
                    "for", 3);

                total += acertos;

                System.out.println("\nPontos na fase 2: " + acertos);

                if (acertos >= 60) {
                    System.out.println("Voce passou para a fase 3!");
                } else {
                    System.out.println("Voce nao atingiu 60 pontos!");
                    passou = false;
                }
            }

            // FASE 3

            if (passou) {

                System.out.println("\n===== FASE 3 =====");
                System.out.println("CONHECIMENTOS GERAIS");

                total += pergunta(
                    "1) Qual e a capital do Brasil?",
                    "Sao Paulo",
                    "Brasilia",
                    "Rio de Janeiro", 2);

                total += pergunta(
                    "2) Quantos dias tem uma semana?",
                    "5",
                    "6",
                    "7", 3);

                total += pergunta(
                    "3) Qual planeta e conhecido como planeta vermelho?",
                    "Marte",
                    "Venus",
                    "Saturno", 1);

                total += pergunta(
                    "4) Qual animal e conhecido como rei da selva?",
                    "Leao",
                    "Elefante",
                    "Macaco", 1);

                total += pergunta(
                    "5) Quanto e 10 x 5?",
                    "15",
                    "50",
                    "100", 2);

                total += pergunta(
                    "6) Qual e o maior oceano do mundo?",
                    "Atlantico",
                    "Pacifico",
                    "Indico", 2);

                total += pergunta(
                    "7) Quantas letras tem o alfabeto portugues?",
                    "26",
                    "24",
                    "28", 1);

                total += pergunta(
                    "8) Qual e o resultado de 100 dividido por 10?",
                    "5",
                    "20",
                    "10", 3);

                total += pergunta(
                    "9) Qual e o satelite natural da Terra?",
                    "Sol",
                    "Lua",
                    "Marte", 2);

                total += pergunta(
                    "10) Qual destes e um sistema operacional?",
                    "Windows",
                    "Java",
                    "HTML", 1);

                System.out.println("\nVoce terminou todas as fases!");
            }

            // RESULTADO FINAL

            System.out.println("\n======================");
            System.out.println("     RESULTADO FINAL");
            System.out.println("======================");

            System.out.println("Jogador: " + nome);
            System.out.println("Pontuacao: " + total);

            nomes.add(nome);
            pontos.add(total);

            System.out.println("\nDeseja jogar novamente?");
            System.out.println("1 - Sim");
            System.out.println("2 - Nao");

            jogar = lerNumero();

            // MOSTRAR RANKING

            ranking();

            if (jogar != 1) {
                jogar = 2;
                System.out.println("\nObrigado por jogar!");
            }
        }
    }
}
