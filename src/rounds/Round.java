package rounds;

import boardandplayer.Board;
import boardandplayer.Player;
import cards.Card;

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

    public void gameAlgorithm(Player player1, Player player2, Board board1, Board board2){
        if(roundNumber == 1){

            player1.shuffle(player1.getDeck(), player1.getHand());
            player2.shuffle(player2.getDeck(), player2.getHand());

            Random random = new Random();
            int head_tails = random.nextInt(2) ;

            if(head_tails == 0){ // player 1 comeca
                while(player1.getHp() == 2 && player2.getHp() == 2 ){ // falta adicionar se o booleano vai ser true ou false para logica de passar o round ou nao

                    int index = 0;
                    for(int i = 0 ; i < player1.getHand().size() ; i++){
                        index++;
                        System.out.println(index + ". " + player1.getHand().get(i).getName());
                    }
                    System.out.println("Qual carta voce deseja jogar: ");
                    int choose = scanner.nextInt();

                    for(int i = 0 ; i < player1.getHand().size(); i++){
                        if(player1.getHand().get(i) == player1.getHand().get(choose)){

                            String card_type = player1.getHand().get(i).getType();

                            if(card_type.equals("Infantary")){
                                //inserir carta de infantaria no tabuleiro
                            }
                            else if(card_type.equals("Artillary")){
                                //inserir carta de artilharia no tabuleiro
                            } else if (card_type.equals("Siege")) {
                                //inserir carta de cerco no tabuleiro
                            }
                        }
                    }

                }
            }
        }
    }
}
