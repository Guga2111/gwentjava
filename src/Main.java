import boardandplayer.Player;
import cards.Card;

import java.util.ArrayList;

public class Main {

    public static void createDeck(ArrayList<Card> listOfCards, Player player){ //parametro tem que ser uma lista de cartas (arraylist com varias cartas)

        ArrayList<Card> deck = new ArrayList<Card>();

        for(Card card : listOfCards){
            deck.add(card);
        }

        player.setDeck(deck);
    }

    public static void main(String[] args) {


    }
}
