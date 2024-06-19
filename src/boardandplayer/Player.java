package boardandplayer;

import cards.Card;
import java.util.ArrayList;
import java.util.Random;

public class  Player {
    //vida do jogador
    private int hp = 2;

    //deck do jogador // no maximo 30 cartas!
    private ArrayList<Card> deck = new ArrayList<Card>();

    //mao do jogador
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Player(){
        deck = new ArrayList<Card>();
    }

    public void shuffle(ArrayList<Card> deck){
        //criacao de objeto para randomizar
        Random random = new Random();

        for(int i = 0 ; i < 10; i++){
            int randomNumber = random.nextInt();
        }
    }
}
