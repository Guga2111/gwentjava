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
    private int infantary_points = 0;
    private int artillary_points = 0;
    private int siege_points = 0;

    //pontos da rodada (do jogador)
    private int points = 0;

    public Board(){
        //construtor da mao do jogador

        //construtor dos campos de batalha
        this.infantary = new ArrayList<>();
        this.artillary = new ArrayList<>();
        this.siege = new ArrayList<>();
    }

    public int getInfantary_points() {
        return infantary_points;
    }

    public void setInfantary_points(int infantary_points) {
        this.infantary_points = infantary_points;
    }

    public int getArtillary_points() {
        return artillary_points;
    }

    public void setArtillary_points(int artillary_points) {
        this.artillary_points = artillary_points;
    }

    public int getSiege_points() {
        return siege_points;
    }

    public void setSiege_points(int siege_points) {
        this.siege_points = siege_points;
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

    public void addPoints(Card card, String card_type){

        int points = card.getPoints();

        if(card_type.equals("infantary") || card_type.equals("Infantary")){

            infantary_points = infantary_points + points;
            this.points = this.points + points;
        }
        else if(card_type.equals("artillary") || card_type.equals("Artillary")){

            artillary_points = artillary_points + points;
            this.points = this.points + points;
        }
        else if(card_type.equals("siege") || card_type.equals("Siege")){

            siege_points = siege_points + points;
            this.points = this.points + points;
        }

    }

}
