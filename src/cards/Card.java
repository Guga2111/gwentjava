package cards;

public class Card {
    private int damage; // Dano da carta (ex: 11).
    private String name; // Nome da carte (ex: "Geralt of Rivia").
    private String type; // Tipo de carta (existem 3: Infantaria, Artilharia, e Cerco).

    public Card(int damage, String name, String type){
        this.damage = damage;
        this.name = name;
        this.type = type;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getDamage(){
        return damage;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
