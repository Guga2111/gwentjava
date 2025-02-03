import boardandplayer.Player;
import cards.Card;
import cards.neutral.GeraltOfRivia;
import cards.neutral.Letho;
import cards.Nilfgaard.*;
import cards.neutral.Triss;
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
        System.out.println("3. Iniciar partida com Bot");
        System.out.println("4. Iniciar partida com Outro player");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void updateInterface(){
        System.out.println("===Escolha!===");
        System.out.println("1. Adicionar carta!");
        System.out.println("2. Remover carta!");
    }

    public static void createDeck(Player player){

        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> ownedCards = player.getOwnedCards();

        for(Card card : ownedCards){
            System.out.println("carta implementada: " + card);
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
        String chooseString = scanner.nextLine();
        int choose = Integer.parseInt(chooseString);

        switch(choose){
            // adição de cartas
            case 1:

                if(player.getOwnedCards().isEmpty()) {
                    break;
                }

                int index = 1;
                for(Card card : player.getOwnedCards()){
                    System.out.println(index + ". " + card.getName());
                    index++;
                }
                int cardChoice = scanner.nextInt();
                player.addCard(player.getOwnedCards().get(cardChoice-1));
                break;
            // remoção de cartas
            case 2:

                if(player.getOwnedCards().isEmpty()) {
                    break;
                }

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

        String emailAnswer = scanner.nextLine();

        System.out.println();

        System.out.println("===Escreva sua senha: ===");
        String passwordAnswer = scanner.nextLine();

        for(int i = 0; i< playerList.size(); i++){
            if(playerList.get(i).getEmail().equals(emailAnswer) && playerList.get(i).checkPassword(passwordAnswer)){
                gameInteraction(playerList,i);
            }
        }

    }

    private static void userRegister(ArrayList<Player> playerList){

        boolean verifyEmail = false;

        while(!verifyEmail) {

            System.out.println("===Escreva seu email: ===");

            String emailRegister = scanner.nextLine();
            System.out.println("email: " + emailRegister);

            boolean emailExists = false;
            for (Player player : playerList) {
                if (emailRegister.equals(player.getEmail())) {
                    System.out.println("Email ja registrado... tente novamente!");
                    emailExists = true;
                    break;
                }
            }

            if(!emailExists) {
                verifyEmail = true;
                System.out.println("Email disponível continue com o registro!");
                System.out.println("===Digite sua senha: ===");
                String passwordRegister = scanner.nextLine();

                Player newPlayer = new Player();
                newPlayer.setEmail(emailRegister);
                newPlayer.setPassword(passwordRegister);
                playerList.add(newPlayer);

                System.out.println("Registro concluído com sucesso!");
            }

        }

    }

    public static void gameInteraction(ArrayList<Player> playerList, int playerIdentifier){

        boolean running = true;
        Player player = playerList.get(playerIdentifier);
        Player bot = playerList.getFirst(); // o bot ficara armezanado na lista de players na posição '0'.

        Round round = new Round();

        Board boardPlayer = new Board();
        Board boardBot = new Board();

        player.setBoard(boardPlayer);
        bot.setBoard(boardBot);

        bot.setName("BOT");
        player.setName("Guga");

        while(running) {

            gameInterface();

            String chooseString = scanner.nextLine();
            int choose = Integer.parseInt(chooseString);

            switch(choose){
                case 1:
                    createListOfCards(player);
                    createDeck(player);
                    break;
                case 2:
                    updateDeck(player);
                    break;
                case 3:
                    round.gameAlgorithm(player, bot);
                    break;
                case 0:
                    System.out.println("Goodbye " + player.getEmail());
                    running = false;
                    break;
                default:
                    break;
            }
        }

    }

    public static void createBot(ArrayList<Player> players) {

        Player bot = new Player();
        bot.setEmail("bot@gmail.com");
        bot.setPassword("123");

        createListOfCards(bot);

        createDeck(bot);

        players.add(bot);
    }
    public static void main(String[] args) {

        ArrayList<Player> playerList = new ArrayList<>();
        createBot(playerList);
        boolean running = true;

        while(running) {
            System.out.println("=== Bem-vindo ao Gwent!===");
            System.out.println("1. Registrar sua conta.");
            System.out.println("2. Fazer o login.");
            System.out.println("0. Sair do Game.");

            String chooseString = scanner.nextLine();
            int choose = Integer.parseInt(chooseString);

            switch(choose){
                case 1:
                    userRegister(playerList);
                    break;
                case 2:
                    userLogin(playerList);
                    break;
                case 0:
                    System.out.println("Exiting the game!");
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }

}
