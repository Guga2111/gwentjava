import boardandplayer.Player;
import cards.Card;
import cards.GeraltOfRivia;
import cards.Letho;
import cards.Nilfgaard.*;
import cards.Triss;
import rounds.Round;
import boardandplayer.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    private static void gameInterface(){

        System.out.println("=== Bem-vindo ao Gwent! ===");
        System.out.println("1. Criar seu deck");
        System.out.println("2. Editar seu deck");
        System.out.println("3. Iniciar partida");
        System.out.println("4. Ver histórico de partidas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

    }

    private static void updateInterface(){
        System.out.println("===Escolha!===");
        System.out.println("1. Adicionar carta!");
        System.out.println("2. Remover carta!");
    }

    public static void createDeck(ArrayList<Card> listOfCards, Player player){ //parametro tem que ser uma lista de cartas (arraylist com varias cartas)

        ArrayList<Card> deck = new ArrayList<Card>();

        for(Card card : listOfCards){
            deck.add(card);
        }

        player.setDeck(deck);
    }

    public static void createListOfCards(Player player){

        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(new GeraltOfRivia());
        cardList.add(new Assire());
        cardList.add(new BlackArcher1());
        cardList.add(new BlackArcher2());
        cardList.add(new Fringilla());
        cardList.add(new Sweers());
        cardList.add(new ZerrikanianScorpion());
        cardList.add(new SiegeEngineer());
        cardList.add(new Manganela());
        cardList.add(new Letho());
        cardList.add(new Triss());

        player.setOwnedCards(cardList);
    }

    public static void updateDeck(Player player){

        updateInterface();
        int choose = scanner.nextInt();

        switch(choose){
            // adição de cartas
            case 1:
                int index = 1;
                for(Card card : player.getOwnedCards()){
                    System.out.println(index + ". " + card.toString());
                }
                int cardChoice = scanner.nextInt();
                player.addCard(player.getOwnedCards().get(cardChoice-1));
                break;
            // remoção de cartas
            case 2:
                int index2 = 1;
                for(Card card : player.getDeck()){
                    System.out.println(index2 + ". " + card.toString());
                }
                int cardChoice2 = scanner.nextInt();
                player.removeCard(player.getDeck().get(cardChoice2-1));
                break;
        }
    }

    private static void userLogin(ArrayList<Player> playerList){

        System.out.println("=== Escreva seu email: ===");
        scanner.nextLine();
        String emailAnswer = scanner.nextLine();

        System.out.println();

        System.out.println("===Escreva sua senha: ===");
        String passwordAnswer = scanner.nextLine();

        for(int i = 0; i< playerList.size(); i++){
            if(playerList.get(i).getEmail().equals(emailAnswer) && playerList.get(i).checkPassword(passwordAnswer)){
                // entra no jogo ( ou seja na interface interativa de criar deck etc)
                gameInteraction(playerList,i);
            }
        }

    }

    private static void userRegister(ArrayList<Player> playerList){


    }

    public static void gameInteraction(ArrayList<Player> playerList, int playerIdentifier){

        gameInterface();

        int choose = scanner.nextInt();

        Player player = playerList.get(playerIdentifier);
        Round round = new Round();
        Player bot = playerList.getFirst(); // o bot ficara armezanado na lista de players na posição '0'.

        switch(choose){
            case 1:
                createListOfCards(player);
                createDeck(player.getOwnedCards(), player);
                break;
            case 2:
                //adicionar ou remover cartas!
                updateDeck(player);
                break;
            case 3:
                round.gameAlgorithm(player, bot);
                break;
        }

    }

    public static void main(String[] args) {

        ArrayList<Player> playerList = new ArrayList<>();

        System.out.println("=== Bem-vindo ao Gwent!===");
        System.out.println("1. Registrar sua conta.");
        System.out.println("2. Fazer o login.");

        int choose = scanner.nextInt();

        switch(choose){
            case 1:

            case 2:
                userLogin(playerList);
        }
    }
}
