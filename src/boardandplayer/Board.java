package boardandplayer;

import cards.Card;

import java.util.ArrayList;

public class Board {
    //cartas que o jogador possui na mao
    //private ArrayList<Card> hand;

    //cartas no campo
    private ArrayList<Card> infantary;
    private ArrayList<Card> artillary;
    private ArrayList<Card> siege;

    //pontos de cada campo
    private final int infantary_points = 0;
    private final int artillary_points = 0;
    private final int siege_points = 0;

    //pontos da rodada (do jogador)
    private int points = 0;

    public Board(){
        //construtor da mao do jogador

        //construtor dos campos de batalha
        this.infantary = new ArrayList<>();
        this.artillary = new ArrayList<>();
        this.siege = new ArrayList<>();
    }

    //getters e setters
    public ArrayList<Card> getInfantary() {
        return infantary;
    }

    public void setInfantary(ArrayList<Card> infantary) {
        this.infantary = infantary;
    }

    public ArrayList<Card> getArtillary() {
        return artillary;
    }

    public void setArtillary(ArrayList<Card> artillary) {
        this.artillary = artillary;
    }

    public ArrayList<Card> getSiege() {
        return siege;
    }

    public void setSiege(ArrayList<Card> siege) {
        this.siege = siege;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addCard(Card card, String card_type){

        if(card_type.equals("infantary") || card_type.equals("Infantary")){
            infantary.add(card);
        }
        else if(card_type.equals("artillary") || card_type.equals("Artillary")){
            artillary.add(card);
        }
        else if(card_type.equals("siege") || card_type.equals("Siege")){
            siege.add(card);
        }
        else{
            System.out.println("Card type not recognized");
        }
    }

}
