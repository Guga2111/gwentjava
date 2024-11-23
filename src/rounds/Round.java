package rounds;

import boardandplayer.Board;
import boardandplayer.Player;
import cards.Card;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    //logica de verificação de quem ganhou o round
    private void verifyPoints(Player player1, Player player2) {

        Board board1 = player1.getBoard();
        Board board2 = player2.getBoard();

        if(board1.getPoints() > board2.getPoints()){
            player2.setHp(player2.getHp() - 1);
        }
        else if(board2.getPoints() > board1.getPoints()){
            player1.setHp(player1.getHp() - 1);
        }
        else{
            player1.setHp(player1.getHp() - 1);
            player2.setHp(player2.getHp() - 1);
        }
        roundNumber++;
    }

    private void playLogic(Player player) {

        ArrayList<Card> playerHand = player.getHand();
        Board board = player.getBoard();

        //basicamente verificaçao se o jogador deseja continuar jogando suas cartas ou nao naquela rodada.
        System.out.println("Voce deseja passar sua vez, responda com (S) ou (N): ");
        char choice = scanner.next().charAt(0);
        if(choice == 'S') {
            player.setContinueMove(false);
            return;
        }
        else{
            player.setContinueMove(true);

            int index = 0;

            for(int i = 0 ; i < player.getHand().size() ; i++){
                index++;
                System.out.println(index + ". " + player.getHand().get(i).getName());
            }
            index = 0;

            System.out.println("Qual carta você deseja jogar: ");
            int choose = scanner.nextInt();


            //verificacao com loop nao seria necessario, porem quero verificar se aquela carta realmente existe!
            for(int i = 0 ; i < player.getHand().size(); i++){
                if(playerHand.get(i) == playerHand.get(choose)){

                    //adicao de carta no tabuleior do jogador 1, na sua devida posicao (artilharia, cerco, ou infantaria)
                    board.addCard(playerHand.get(choose), playerHand.get(choose).getType());
                    playerHand.remove(choose);
                }

            }
        }

    }

    private void roundLogic(Player player1, Player player2){

        Random random = new Random();
        int head_tails = random.nextInt(2);

        if(head_tails == 0){ // player 1 comeca
            while(player1.getHp() != 0 && player2.getHp() != 0 && (player1.isContinueMove() || player2.isContinueMove())){ // falta adicionar se o booleano vai ser true ou false para logica de passar o round ou nao

                playLogic(player1);
                playLogic(player2);

            }
            verifyPoints(player1, player2);

        }
        else if(head_tails == 1){ //player 2 comeca
            while(player1.getHp() != 0 && player2.getHp() != 0 && (player1.isContinueMove() || player2.isContinueMove())){ // falta adicionar se o booleano vai ser true ou false para logica de passar o round ou nao

                playLogic(player2);
                playLogic(player1);

            }
            verifyPoints(player1, player2);

        }
    }
    public void gameAlgorithm(Player player1, Player player2){

        //embaralha as cartas que irao para a mao de forma aleatoria (10 cartas)
        player1.shuffle(player1.getDeck(), player1.getHand());
        player2.shuffle(player2.getDeck(), player2.getHand());

        if(roundNumber == 1){

            roundLogic(player1, player2);
        }
        else if(roundNumber == 2){
            //cotninuacao
            roundLogic(player1, player2);
        }
        else if(roundNumber == 3 && (player1.getHp() !=0 || player2.getHp() !=0)){

            roundLogic(player1, player2);
        }
        else{
            System.out.println("The game is over!");
        }
    }
}
