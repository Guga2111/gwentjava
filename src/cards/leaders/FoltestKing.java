package cards.leaders;

import cards.Card;

import java.util.Arrays;
import java.util.List;

public class FoltestKing extends Card {
    //pick a fog card from your deck and play it instantly
    public FoltestKing() {
        super(0, "Foltest King of Temeria", "Leader", List.of(
                "Leader", "FogClimate"
        ));
    }
}
