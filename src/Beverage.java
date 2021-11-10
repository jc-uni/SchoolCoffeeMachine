import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Beverage {

    enum BeverageType{COFFEE, ESPRESSO, AMERICANO, COCOA, WATER}

    ArrayList<HashMap<BeverageType,Integer>> pricesOfDrinks = new ArrayList<>();

    BeverageType GetTypeOfBeverage();
    int GetPriceOfBeverage(BeverageType BT);
}
