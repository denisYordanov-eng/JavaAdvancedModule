package enumerations_and_annotations.custom_enum_annotation;

public class Card implements Comparable<Card>{
  private Rank rankPower;
  private Suit suitPower;

    public Card(Rank rankPower, Suit suitPower) {
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
