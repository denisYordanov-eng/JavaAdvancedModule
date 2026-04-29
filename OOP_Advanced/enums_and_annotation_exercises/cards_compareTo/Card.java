package enumerations_and_annotations.cards_compareTo;

public class Card implements Comparable<Card>{
  private  RankPowers rankPower;
  private SuitPowers suitPower;

    public Card(RankPowers rankPower, SuitPowers suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }
    public Integer calculatePower() {
        return rankPower.getPower() + suitPower.getPower();
    }
    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                rankPower.toString()
                , suitPower.toString()
        , calculatePower());
    }


    @Override
    public int compareTo(Card cardTwo) {
        return cardTwo.calculatePower().compareTo(this.calculatePower());
    }
}
