package boardandplayer;

import cards.Card;

import java.util.ArrayList;

public class Board {
    //cartas que o jogador possui na mao
    private ArrayList<Card> hand;

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

    public tabuleiro(){
        //construtor da mao do jogador
        this.hand = new ArrayList<>();

        //construtor dos campos de batalha
        this.infantary = new ArrayList<>();
        this.artillary = new ArrayList<>();
        this.siege = new ArrayList<>();
    }

    //getters e setters
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
