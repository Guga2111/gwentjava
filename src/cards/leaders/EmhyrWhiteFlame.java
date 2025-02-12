package cards.leaders;

import cards.Card;

import java.util.Arrays;
import java.util.List;

public class EmhyrWhiteFlame extends Card {

    //Cancel the opponent leader's ability
    public EmhyrWhiteFlame() {
        super(0, "Emhyr var Emreis the White Flame", "Leader", List.of(
                "Leader", "Cancel"
        ));

    }
}
