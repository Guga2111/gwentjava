package boardandplayer;

import cards.Card;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> infantry;
    private ArrayList<Card> artillary;
    private ArrayList<Card> siege;
    private int infantry_points = 0;
    private int artillary_points = 0;
    private int siege_points = 0;
    private int points = 0;

    public Board(){
        this.infantry = new ArrayList<>();
        this.artillary = new ArrayList<>();
        this.siege = new ArrayList<>();
    }

    public int getInfantry_points() {
        return infantry_points;
    }

    public void setInfantry_points(int infantry_points) {
        this.infantry_points = infantry_points;
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
    public ArrayList<Card> getInfantry() {
        return infantry;
    }

    public void setInfantry(ArrayList<Card> infantry) {
        this.infantry = infantry;
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

        if(card_type.equals("infantry") || card_type.equals("Infantry")){
            infantry.add(card);
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

    // tlvz seja interessante utilizar switch case!
    // utilizar essa function para adicionar pontos dependendo do tipo de carta
    public void addPoints(Card card, String card_type){

        int points = card.getPoints();

        if(card_type.equals("infantry") || card_type.equals("Infantry")){
            infantry_points = infantry_points + points;
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
