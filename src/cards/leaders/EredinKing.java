package cards.leaders;

import cards.Card;

import java.util.List;

public class EredinKing extends Card {
    // pick any weather card from your deck and play it instantly
    public EredinKing() {
        super(0, "Eredin King of the Wild Hunt", "Leader", List.of(
                "Leader", "AnyClimate")
        );
    }
}
