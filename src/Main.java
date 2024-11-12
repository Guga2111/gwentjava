import boardandplayer.Player;
import cards.Card;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    private static void gameInterface(){

        System.out.println("=== Bem-vindo ao Gwent! ===");
        System.out.println("1 - Criar seu deck");
        System.out.println("2 - Editar seu deck");
        System.out.println("3 - Iniciar partida");
        System.out.println("4 - Ver histórico de partidas");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");

    }

    public static void createDeck(ArrayList<Card> listOfCards, Player player){ //parametro tem que ser uma lista de cartas (arraylist com varias cartas)

        ArrayList<Card> deck = new ArrayList<Card>();

        for(Card card : listOfCards){
            deck.add(card);
        }

        player.setDeck(deck);
    }

    private static void userLogin(ArrayList<Player> playerList){

        System.out.println("=== Escreva seu email: ===");
        String emailAnswer = scanner.nextLine();

        System.out.println("===Escreva sua senha: ===");
        String passwordAnswer = scanner.nextLine();

        for(int i = 0; i < playerList.size(); i++){
            if(playerList.get(i).getEmail().equals(emailAnswer) && playerList.get(i).checkPassword(passwordAnswer)){
                // entra no jogo ( ou seja na interface interativa de criar deck etc)

                gameInteraction(i);
            }

        }


    }

    public static void gameInteraction(int playerIdentifier){

        gameInterface();

        int choose = scanner.nextInt();

        switch(choose){
            case 1:
                createDeck();
        }

    }
    public static void main(String[] args) {

        ArrayList<Player> playerList = new ArrayList<>();

        System.out.println("=== Bem-vindo ao Gwent!===");
        System.out.println("1 - Registrar sua conta.");
        System.out.println("2 - Fazer o login.");

        int choose = scanner.nextInt();

        switch(choose){
            case 1:

            case 2:
                userLogin(playerList);
        }
    }
}
