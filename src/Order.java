public class Order implements Customer,Beverage{

    BeverageType SelectedBeverage;
    CustomerType SelectedCustomer;

    int SizeOfBeverageType =Beverage.BeverageType.values().length;

    public Order() {}

    public void DeliverDrink(){

        System.out.println("Your account will be charged " +FinalPrice());
        if (Payment(FinalPrice())) {
            System.out.println("Take your drink.");
        } else
            System.out.println("Payment failed.");

    }

    //TODO Payments system, via school ID
    private boolean Payment(double price){
        return true;
    }

    private double FinalPrice(){
        return drinksAndTheirPrices.get(SelectedBeverage) * GetPriceModifier(SelectedCustomer);
    }

    @Override
    public BeverageType GetBeverageType(String name) {
        return BeverageType.valueOf(name);
    }

    @Override
    public void SetPricesOfDrinks() {
        int i = 0;
        for(BeverageType b : BeverageType.values()){
            drinksAndTheirPrices.put(b,listOfPrices[i]);
            i++;
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

    @Override
    public CustomerType GetCustomerType(String name) {
        return CustomerType.valueOf(name);
    }
}
