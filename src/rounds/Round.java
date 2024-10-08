package rounds;

import boardandplayer.Board;
import boardandplayer.Player;
import cards.Card;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Round {

    private Scanner scanner = new Scanner(System.in);
    private int roundNumber = 1;

    public Round() {

    }

    public int getRoundNumber() {
        return roundNumber;
    }
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void playLogic(Player player, Board board, ArrayList<Card> playerHand) {

        int index1 = 0;
        for(int i = 0 ; i < player.getHand().size() ; i++){
            index1++;
            System.out.println(index1 + ". " + player.getHand().get(i).getName());
        }
        index1 = 0;

        System.out.println("Qual carta voce deseja jogar: ");
        int choose1 = scanner.nextInt();

        //verificacao com loop nao seria necessario, porem quero verificar se aquela carta realmente existe!
        for(int i = 0 ; i < player.getHand().size(); i++){
            if(playerHand.get(i) == playerHand.get(choose1)){

                //adicao de carta no tabuleior do jogador 1, na sua devida posicao (artilharia, cerco, ou infantaria)
                board.addCard(playerHand.get(choose1), playerHand.get(choose1).getType());
            }

        }
    }

    public void gameAlgorithm(Player player1, Player player2, Board board1, Board board2){
        if(roundNumber == 1){

            //embaralha as cartas que irao para a mao de forma aleatoria (10 cartas)
            player1.shuffle(player1.getDeck(), player1.getHand());
            player2.shuffle(player2.getDeck(), player2.getHand());

            ArrayList<Card> player1Hand = player1.getHand();
            ArrayList<Card> player2Hand = player2.getHand();

            Random random = new Random();
            int head_tails = random.nextInt(2);

            if(head_tails == 0){ // player 1 comeca
                while(player1.getHp() == 2 && player2.getHp() == 2){ // falta adicionar se o booleano vai ser true ou false para logica de passar o round ou nao

                    playLogic(player1, board1, player1Hand);
                    playLogic(player2, board2, player2Hand);

                }
            }
            else if(head_tails == 1){ //player 2 comeca
                while(player1.getHp() == 2 && player2.getHp() == 2 ){ // falta adicionar se o booleano vai ser true ou false para logica de passar o round ou nao

                    playLogic(player2, board2, player2Hand);
                    playLogic(player1, board1, player1Hand);

                }

            }
        }
    }
}
