package cards;

import java.util.List;
import java.util.UUID;

public class Card {
    private String id;
    private int points; // Dano da carta (ex: 11).
    private final String name; // Nome da carte (ex: "Geralt of Rivia").
    private String type; // Tipo de carta (existem 3: Infantaria, Artilharia, e Cerco) ou Lider ou Especial ( corneta, caveira (de matar as cartas mais fortes)) ou Climaticas
    private List<String> abilities;

    public Card(int damage, String name, String type, List<String> abilities){
        this.points = damage;
        this.name = name;
        this.type = type;
        this.abilities = abilities;
        this.id = UUID.randomUUID().toString();
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
