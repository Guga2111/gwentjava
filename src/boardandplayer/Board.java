package boardandplayer;

import cards.Card;

import java.util.ArrayList;

public class Board {
    private ArrayList<Card> infantry;
    private ArrayList<Card> artillary;
    private ArrayList<Card> siege;
    private ArrayList<Card> discard;
    private int infantry_points = 0;
    private int artillary_points = 0;
    private int siege_points = 0;
    private int points = 0;

    public Board(){
        this.infantry = new ArrayList<>();
        this.artillary = new ArrayList<>();
        this.siege = new ArrayList<>();
        this.discard = new ArrayList<>();
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

    public ArrayList<Card> getDiscard() {
        return discard;
    }

    public void setDiscard(ArrayList<Card> discard) {
        this.discard = discard;
    }

    public void addCard(Card card, String card_type) {

        switch (card_type.toLowerCase()) {
            case "infantry":
                infantry.add(card);
                addPoints(card, card_type.toLowerCase());
                break;
            case "artillary":
                artillary.add(card);
                addPoints(card, card_type.toLowerCase());
                break;
            case "siege":
                siege.add(card);
                addPoints(card, card_type.toLowerCase());
                break;
            default:
                System.out.println("Card type not recognized");
                break;
        }
    }


    public void addPoints(Card card, String card_type){

        int points = card.getPoints();

        switch (card_type.toLowerCase()) {
            case "infantry":
                System.out.println("entrou");
                infantry_points = infantry_points + points;
                this.points = this.points + points;
                break;
            case "artillary":
                System.out.println("entrou");
                artillary_points = artillary_points + points;
                this.points = this.points + points;
                break;
            case "siege":
                siege_points = siege_points + points;
                this.points = this.points + points;
                break;
            default:
                System.out.println("Esse tipo não existe!");
        }

    }

    public void eraseBoard () {

        discard.addAll(infantry);
        discard.addAll(artillary);
        discard.addAll(siege);

        infantry.clear();
        artillary.clear();
        siege.clear();

        infantry_points = 0;
        artillary_points = 0;
        siege_points = 0;
        points = 0;
    }

    //pensar num refac
    public void showBoard(Player player1, Player player2) {

        Board board1 = player1.getBoard();
        Board board2 = player2.getBoard();

        System.out.println("=== " + board2.getPoints() + "===");
        System.out.println("===" + player2.getName() + "===");

        System.out.println("SIEGE: " + board2.getSiege_points() + " pts.");
        System.out.println("ARTILLARY: " + board2.getArtillary_points() + " pts.");
        System.out.println("INFANTRY: " + board2.getInfantry_points() + " pts.");

        System.out.println("-----*------*------*------*------");

        System.out.println("INFANTRY: " + board1.getInfantry_points() + " pts.");
        System.out.println("ARTILLARY: " + board1.getArtillary_points() + " pts.");
        System.out.println("SIEGE: " + board1.getSiege_points() + " pts.");

        System.out.println("===" + player1.getName() + "===");
        System.out.println("=== " + board1.getPoints() + "===");
    }

}
