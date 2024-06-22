package rounds;

// importando as classes 'board' e 'player'
import boardandplayer.Board;
import boardandplayer.Player;
import cards.Card;

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

    public void verifyWinner(Board board1, Board board2, Player player1, Player player2) {

        if(player1.getHp() == 0 || player2.getHp() == 0) {
            System.out.println("THE GAME IS OVER!");
        }

        if(board1.getPoints() > board2.getPoints()) {
            player2.setHp(player2.getHp() - 1);
        }
        else if(board2.getPoints() > board1.getPoints()) {
            player1.setHp(player1.getHp() - 1);
        }
        else{
            player1.setHp(player1.getHp() - 1);
            player2.setHp(player2.getHp() - 1);
        }

    }

    public void roundMechanic(Board board1, Board board2, Player player1, Player player2){

        int isPass; //flag para passar ou nao a sua vez
        boolean isRound = true; //flag para definir quando o round acaba

        // loop para logica do jogo que acontecera enquanto a vida dos jogadores for diferente de algo (a definir).
        while(isRound){
            System.out.println("1. JOGAR");
            System.out.println("2. PASSAR");
            int decision = scanner.nextInt();

            if(decision == 1){
                System.out.println("Qual carta você deseja jogar, "+ player1.getName() +"?");
                System.out.println(player1.getHand());
                String nameTemp1 = scanner.nextLine();

                for(int i = 0; i < player1.getHand().size(); i++){
                    if(nameTemp1.equals(player1.getHand().get(i).getName())){

                        //variavel para carta identificada na mao do jogador
                        Card card = player1.getHand().get(i);

                        if(card.getType().equals("Artilharia")){
                            board1.addArtillaryCard(card);
                        }
                        else if(card.getType().equals("Infantaria")){
                            board1.addInfantCard(card);
                        }
                        else if(card.getType().equals("Cerco")){
                            board1.addSiegeCard(card);
                        } else{
                            System.out.println("TIPO NAO IDENTIFICADO!");
                        }

                    }
                }

                System.out.println("Qual carta você deseja jogar, "+ player2.getName() +"?");
                System.out.println(player2.getHand());
                String nameTemp2 = scanner.nextLine();

                for(int i = 0; i < player2.getHand().size(); i++){
                    if(nameTemp2.equals(player2.getHand().get(i).getName())){

                        //variavel para carta identificada na mao do jogador
                        Card card = player2.getHand().get(i);

                        if(card.getType().equals("Artilharia")){
                            board2.addArtillaryCard(card);
                        }
                        else if(card.getType().equals("Infantaria")){
                            board2.addInfantCard(card);
                        }
                        else if(card.getType().equals("Cerco")){
                            board2.addSiegeCard(card);
                        } else{
                            System.out.println("TIPO NAO IDENTIFICADO!");
                        }

                    }
                }
            }

            else if(decision == 2){
                isRound = false;


            }


        }
    }
}
