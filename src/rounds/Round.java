package rounds;

import boardandplayer.Board;
import boardandplayer.Player;

import java.util.Random;

public class Round {

    private int roundNumber = 1;

    public Round() {

    }

    public int getRoundNumber() {
        return roundNumber;
    }
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void game(Player player1, Player player2, Board board1, Board board2){
        if(roundNumber == 1){

            player1.shuffle(player1.getDeck(), player1.getHand());
            player2.shuffle(player2.getDeck(), player2.getHand());

            Random random = new Random();
            int head_tails = random.nextInt(2) ;

            if(head_tails == 0){
                while(player1.getHp() == 2 && player2.getHp() == 2){

                }
            }
        }
    }
}
