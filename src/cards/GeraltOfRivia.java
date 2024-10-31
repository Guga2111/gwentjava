package cards;

public class GeraltOfRivia extends Card {
    private String abilitie;

    public GeraltOfRivia(){
        super(15, "Geralt of Rivia", "Infantry"); // Herda da superclasse 'Card'.
        this.abilitie = "Kill up to 10";
    }

    public void setAbilitie(String abilitie){
        this.abilitie = abilitie;
    }

    public String getAbilitie(){
        return abilitie;
    }
}
