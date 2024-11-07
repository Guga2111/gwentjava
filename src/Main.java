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

    private static void gameInterface(){

        System.out.println("=== Bem-vindo ao Jogo de Cartas! ===");
        System.out.println("1 - Criar seu deck");
        System.out.println("2 - Editar seu deck");
        System.out.println("3 - Iniciar partida");
        System.out.println("4 - Ver histórico de partidas");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");

    }

    public static void main(String[] args) {


    }
}
