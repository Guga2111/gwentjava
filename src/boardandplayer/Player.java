package boardandplayer;

import cards.Card;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import java.security.MessageDigest;


public class Player {
    //vida do jogador
    private int hp = 2;

    //deck do jogador // no maximo 40 cartas!
    private ArrayList<Card> deck = new ArrayList<Card>();

    //mao do jogador
    private ArrayList<Card> hand = new ArrayList<Card>();

    private ArrayList<Card> ownedCards = new ArrayList<>();
    private boolean continueMove = true;
    //email do jogador
    private String email;
    //senha do jogador (armezanda como hash)
    private String passwordHash;

    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.passwordHash = hashPassword(password);
    }

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

    public boolean isContinueMove() {
        return continueMove;
    }

    public void setContinueMove(boolean continueMove) {
        this.continueMove = continueMove;
    }

    public ArrayList<Card> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(ArrayList<Card> ownedCards) {
        this.ownedCards = ownedCards;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao calcular o hash da senha", e);
        }
    }

    public boolean checkPassword(String password) {
        return hashPassword(password).equals(this.passwordHash);
    }

    public void shuffle(ArrayList<Card> deck, ArrayList<Card> hand){
        //criacao de objeto para randomizar
        Random random = new Random();

        while(hand.size() < 10){

            int randomNumber = random.nextInt(deck.size());

            hand.add(deck.get(randomNumber));

        }
    }

    public void addCard(Card card){

        deck.add(card);
    }

    public void removeCard(Card card){

        deck.remove(card);
    }
}
