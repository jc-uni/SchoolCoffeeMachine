import java.util.HashMap;
import java.util.HashSet;

public class Order implements Customer,Beverage{

    BeverageType SelectedBeverage;
    CustomerType SelectedCustomer;
    //HashSet<HashMap> loremipsum = new HashSet<HashMap>();
    //HashMap<CustomerType,HashMap<BeverageType,Integer>> NetPrice = new HashMap<>();
    HashSet<HashMap<CustomerType,HashMap<BeverageType,Integer>>> Prices= new HashSet<>();

    public Order() {

        SelectedBeverage=BeverageType.COCOA;


        //Prices.add();
        for (BeverageType bt : BeverageType.values()){
            for(CustomerType ct : CustomerType.values()){

            }
        }






    }

    public double FinalPrice(){
        return 0;
    }



    @Override
    public BeverageType GetTypeOfBeverage() {
        return SelectedBeverage;
    }

    @Override
    public int GetPriceOfBeverage(BeverageType BT) {
        int price = 0;

        //if

        return price;
    }

    @Override
    public CustomerType GetTypeOfCustomer() {
        return null;
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
