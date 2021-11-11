import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Order implements Customer,Beverage{

    BeverageType SelectedBeverage;
    CustomerType SelectedCustomer;

    int SizeOfBeveragetype =Beverage.BeverageType.values().length;

    public Order() {



    }

    public void DeliverDrink(){


        if (Payment(FinalPrice())){
            System.out.println("Take your drink.");
        }
        else
            System.out.println("Payment failed.");

    }

    //TODO Payments system, via school ID
    private boolean Payment(double price){
        return true;
    }

    private double FinalPrice(){

        //int price = pricesOfDrinks.contains(SelectedBeverage);

        //int price = pricesOfDrinks.contains(SelectedBeverage) / GetPriceModifier(SelectedCustomer);

        return 0;
    }

    @Override
    public BeverageType GetBeverageType(String name) {
        return BeverageType.valueOf(name);
    }

    @Override
    public void SetPricesOfDrinks() {

        for(BeverageType b : BeverageType.values()){
            for (int i = 0; i<listOfPrices.length; i++){
                aDrinkAndItsPrice.put(b,i);
                pricesOfDrinks.add(aDrinkAndItsPrice);
            }

        }

    }

    @Override
    public void ListOutDrinks() {
        for (BeverageType aDrink : BeverageType.values()) {
            System.out.println(aDrink);
        }
    }

    @Override
    public double GetPriceModifier(CustomerType CT) {

        double priceModifier = 0;

        if(CT == CustomerType.FACULTY){
            priceModifier = 0.2;
        }
        else if (CT == CustomerType.STUDENT){
            priceModifier = 0.5;
        }
        else if (CT == CustomerType.GUEST){
            priceModifier = 1.0;
        }

        return priceModifier;
    }
}
