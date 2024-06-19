package boardandplayer;

import cards.Card;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    //vida do jogador
    private int hp = 2;

    //nome definido no main (ex: victor).
    private String name;

    //deck do jogador // no maximo 30 cartas!
    private ArrayList<Card> deck = new ArrayList<Card>();

    //mao do jogador
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Player(String name){
        deck = new ArrayList<Card>();
        this.name = name;
    }

    public void shuffle(ArrayList<Card> deck){
        //criacao de objeto para randomizar
        Random random = new Random();

        for(int i = 0 ; i < 10; i++){
            int randomNumber = random.nextInt();
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
