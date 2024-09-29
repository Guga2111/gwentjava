package boardandplayer;

import cards.Card;
import rounds.Plays;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    //vida do jogador
    private int hp = 2;

    //deck do jogador // no maximo 30 cartas!
    private ArrayList<Card> deck = new ArrayList<Card>();

    //mao do jogador
    private ArrayList<Card> hand = new ArrayList<Card>();

    private Plays plays;

    public Player(){
        deck = new ArrayList<Card>();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void shuffle(ArrayList<Card> deck, ArrayList<Card> hand){
        //criacao de objeto para randomizar
        Random random = new Random();

        while(hand.size() < 10){

            int randomNumber = random.nextInt(deck.size());

            hand.add(deck.get(randomNumber));

        }
    }
}
