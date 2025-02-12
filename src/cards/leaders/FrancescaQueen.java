package cards.leaders;

import cards.Card;

import java.util.List;

public class FrancescaQueen extends Card {
    //Destroy enemy's strongest infantry card, if the sum of infantry points is 10+
    public FrancescaQueen() {
        super(0, "Francesca Findabair Queen of Dol Blathanna", "Leader", List.of(
                "Leader", "DestroyInfantry"
        ));
    }
}
