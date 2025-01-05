package rounds;

import boardandplayer.Board;
import boardandplayer.Player;
import cards.Card;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Round {

    private final Scanner scanner = new Scanner(System.in);
    private int roundNumber = 1;

    public Round() {

    }

    public int getRoundNumber() {
        return roundNumber;
    }
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    private void eraseBoards(Player player1, Player player2) {
        player1.getBoard().eraseBoard();
        player2.getBoard().eraseBoard();
    }
    private void verifyPoints(Player player1, Player player2) {

        Board board1 = player1.getBoard();
        Board board2 = player2.getBoard();

        if(board1.getPoints() > board2.getPoints()){
            player2.setHp(player2.getHp() - 1);
            System.out.println("Player1 ganhou esse round.");
        }
        else if(board2.getPoints() > board1.getPoints()){
            player1.setHp(player1.getHp() - 1);
            System.out.println("Player2 ganhou esse round.");
        }
        else{
            player1.setHp(player1.getHp() - 1);
            player2.setHp(player2.getHp() - 1);
            System.out.println("Ambos players empataram!");
        }
        roundNumber++;
        System.out.println("Vamos para o round: " + roundNumber);
    }

    private void playLogic(Player player) {

        ArrayList<Card> playerHand = player.getHand();
        Board board = player.getBoard();

        System.out.println("Voce deseja passar sua vez, responda com (S) ou (N): ");
        String choice = scanner.nextLine();

        if(Arrays.asList(Constants.ANSWERS).contains(choice)) {
            player.setContinueMove(false);
        }
        else{
            player.setContinueMove(true);

            int index = 1;

            for(int i = 0; i < playerHand.size(); i++) {
                System.out.println(index + ". " + playerHand.get(i).getName());
                index++;
            }

            System.out.println("Qual carta você deseja jogar: ");
            String chooseString = scanner.nextLine();
            int choose = Integer.parseInt(chooseString);
            choose--;

            //upgrade to a for each loop
            for(int i = 0 ; i < playerHand.size(); i++) {
                if(playerHand.get(i) == playerHand.get(choose)) {
                    board.addCard(playerHand.get(choose), playerHand.get(choose).getType());
                    playerHand.remove(choose);
                }
            }
        }
    }

    private void roundLogic(Player player1, Player player2) {

        Random random = new Random();
        int head_tails = random.nextInt(2);

        Player firstPlayer = (head_tails == 0) ? player1 : player2;
        Player secondPlayer = (head_tails == 0) ? player2 : player1;

        System.out.print("O jogador inicial será: " + (head_tails == 0 ? "Player 1" : "Player 2"));
        System.out.println(" -> " + firstPlayer.getName());

        while ((player1.getHp() > 0 && player2.getHp() > 0) && (player1.isContinueMove() || player2.isContinueMove())) {

            if (player1.getHp() <= 0 || player2.getHp() <= 0) {
                break;
            }

            if(player1.isContinueMove()) {
                firstPlayer.getBoard().showBoard(player1, player2);
                playLogic(firstPlayer);
            }

            if(player2.isContinueMove()) {
                secondPlayer.getBoard().showBoard(player1, player2);
                playLogic(secondPlayer);
            }

        }
        verifyPoints(player1, player2);
    }

    public void gameAlgorithm(Player player1, Player player2) {

        player1.shuffle(player1.getDeck(), player1.getHand());
        player2.shuffle(player2.getDeck(), player2.getHand());

        System.out.println("Player1: ");
        for(Card card : player1.getHand()) {
            System.out.println(card.getName());
        }

        System.out.println("Player2: ");
        for(Card card : player2.getHand()) {
            System.out.println(card.getName());
        }

        while(player1.getHp() > 0 || player2.getHp() > 0 && roundNumber < 4) {

            System.out.println("Está começando o round: " + roundNumber);

            eraseBoards(player1,player2);
            player1.setContinueMove(true);
            player2.setContinueMove(true);


            roundLogic(player1,player2);
        }

        if (player1.getHp() <= 0 && player2.getHp() <= 0) {
            System.out.println("O jogo terminou em empate!");
        } else if (player1.getHp() > 0) {
            System.out.println("Player1 venceu o jogo!");
        } else {
            System.out.println("Player2 venceu o jogo!");
        }
    }
}
