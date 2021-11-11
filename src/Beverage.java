import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Beverage {

    enum BeverageType{COFFEE, ESPRESSO, AMERICANO, COCOA, WATER}
    int[] listOfPrices = {10,20,30,40,50};

    HashSet<HashMap<BeverageType,Integer>> pricesOfDrinks = new HashSet<>();
    HashMap<BeverageType,Integer> aDrinkAndItsPrice = new HashMap<>();

    BeverageType GetBeverageType(String name);

    void SetPricesOfDrinks();
    void ListOutDrinks();

}
