import java.util.HashMap;

public interface Beverage {

    enum BeverageType{COFFEE, ESPRESSO, AMERICANO, COCOA, WATER}
    int[] listOfPrices = {20,30,30,20,0};

    HashMap<BeverageType,Integer> drinksAndTheirPrices = new HashMap<>();

    BeverageType GetBeverageType(String name);

    void SetPricesOfDrinks();
    void ListOutDrinks();

}
