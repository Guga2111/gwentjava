package cards;

public class GeraltOfRivia extends Card {
    private String abilitie;

    public GeraltOfRivia(int damage, String name, String type, String abilitie){
        super(damage, name, type); // Herda da superclasse 'Card'.
        this.abilitie = abilitie;
    }

    public void setAbilitie(String abilitie){
        this.abilitie = abilitie;
    }

    public String getAbilitie(){
        return abilitie;
    }
}
