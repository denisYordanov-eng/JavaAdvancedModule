package coffee_machine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
private List<Coin> coins;
private List<Coffee> coffees;

    public CoffeeMachine() {
        this.coins = new ArrayList<>();
        this.coffees = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        CoffeeSize coffeeSize = CoffeeSize.valueOf(size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(type.toUpperCase());

        int availableCoins = this.coins.stream().map(Coin::getValue).mapToInt(Integer::intValue).sum();
        int price = coffeeSize.getCoin();
        if(availableCoins >= price){
            coffees.add(new Coffee(coffeeSize, coffeeType));
            this.coins.clear();
        }
    }

    public void insertCoin(String coin){
        this.coins.add(Coin.valueOf(coin));
    }

    public Iterable<Coffee> coffeesSold(){
        return this.coffees;
    }
}
