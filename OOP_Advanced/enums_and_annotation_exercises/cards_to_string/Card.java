package enumerations_and_annotations.cards_to_string;

public class Card {
  private  RankPowers rankPower;
  private SuitPowers suitPower;

    public Card(RankPowers rankPower, SuitPowers suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }
    private int calculatePower() {
        return rankPower.getPower() + suitPower.getPower();
    }
    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                rankPower.toString()
                , suitPower.toString()
        , calculatePower());
    }
}
