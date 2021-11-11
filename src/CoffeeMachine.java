import java.util.Scanner;

public class CoffeeMachine {

    enum States {ENTRY, SELECTION, DELIVERY, EXIT}
    States StateMachine = States.ENTRY;

    public CoffeeMachine() {

        while (StateMachine != States.EXIT) {
            var scanner = new Scanner(System.in);
            Order AnOrder = new Order();
            AnOrder.SetPricesOfDrinks();

            //Identify student, faculty, or guest
            while (StateMachine == States.ENTRY){
                System.out.println("Welcome");
                System.out.println("Select customer type:");
                System.out.println("1, faculty. 2, student. 3, guest");
                String inputSelectedCustomerType = scanner.nextLine();

                switch (inputSelectedCustomerType) {
                    case "1" -> AnOrder.SelectedCustomer = Customer.CustomerType.FACULTY;
                    case "2" -> AnOrder.SelectedCustomer = Customer.CustomerType.STUDENT;
                    case "3" -> AnOrder.SelectedCustomer = Customer.CustomerType.GUEST;
                }
                StateMachine = States.SELECTION;
            }

            //Select product
            while (StateMachine == States.SELECTION){
                System.out.println("What would you like to drink?");
                System.out.println("We have:");
                AnOrder.ListOutDrinks();
                System.out.println("Press key # 1-" + AnOrder.SizeOfBeveragetype);
                System.out.println("Press 'c' to cancel order");
                String inputSelectedBeverageType = scanner.nextLine();

                switch (inputSelectedBeverageType){
                    case "c" -> StateMachine = States.SELECTION;
                    case "1" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("COFFEE");
                    case "2" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("ESPRESSO");
                    case "3" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("AMERICANO");
                    case "4" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("COCOA");
                    case "5" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("WATER");
                }
                if(AnOrder.SelectedBeverage == null){
                    System.out.println("Invalid choice. Press 1-" +AnOrder.SizeOfBeveragetype +" or c to cancel");
                }
                else
                    StateMachine = States.DELIVERY;
            }

            //Pay, deliver order, & exit
            while (StateMachine == States.DELIVERY){
                System.out.println("You have selected:");
                System.out.println(AnOrder.SelectedBeverage);
                System.out.println("Confirm, (y)es or (n)o:");
                String inputConfirmation = scanner.nextLine();

                if ("y".equals(inputConfirmation)) {
                    AnOrder.DeliverDrink();
                    StateMachine = States.ENTRY;
                }
                else if ("n".equals(inputConfirmation)) {
                    StateMachine = States.SELECTION;
                }
                else
                    System.out.println("Invalid input.");
            }
        }
    }
}
