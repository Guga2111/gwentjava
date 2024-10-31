package cards;

public class Card {
    private int points; // Dano da carta (ex: 11).
    private final String name; // Nome da carte (ex: "Geralt of Rivia").
    private final String type; // Tipo de carta (existem 3: Infantaria, Artilharia, e Cerco).

    public Card(int damage, String name, String type){
        this.points = damage;
        this.name = name;
        this.type = type;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getPoints(){
        return points;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }
}
