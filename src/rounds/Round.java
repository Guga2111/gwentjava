package rounds;

// importando as classes 'board' e 'player'
import boardandplayer.Board;
import boardandplayer.Player;

// importando funcionalidades
import java.util.ArrayList;
import java.util.Scanner;

public class Round {

    Scanner scanner = new Scanner(System.in);

    private int roundNumber = 0;

    public Round() {

    }

    public int getRoundNumber() {
        return roundNumber;
    }
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void roundMechanic(Board board, Player player1, Player player2){

        int isPass; //flag para passar ou nao a sua vez

        // loop para logica do jogo que acontecera enquanto a vida dos jogadores for diferente de algo (a definir).
        while(){
            System.out.println("Qual carta você deseja jogar, "+ player1.getName() +"?");
            System.out.println(player1.getHand());
            String nameTemp = scanner.nextLine();

            for(int i = 0; i < player1.getHand().size(); i++){
                if(nameTemp.equals(player1.getHand().get(i).getName())){
                    if(player1.getHand().get(i).getType().equals("Artilharia")){
                         // pensar melhor aqui
                    }
                }
            }
        }
    }
}
