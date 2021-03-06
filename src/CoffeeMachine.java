import java.util.Scanner;

public class CoffeeMachine {

    public CoffeeMachine() {

        enum States {ENTRY, SELECTION, DELIVERY, EXIT}
        States StateMachine = States.ENTRY;

        while (StateMachine != States.EXIT) {
            var scanner = new Scanner(System.in);
            Order AnOrder = new Order();
            AnOrder.SetPricesOfDrinks();

            //Identify student, faculty, or guest
            while (StateMachine == States.ENTRY){
                System.out.print("\r\nWelcome\r\nSelect customer type:\r\n1, faculty. 2, student. 3, guest");

                String inputSelectedCustomerType = scanner.nextLine();

                switch (inputSelectedCustomerType) {
                    case "1" -> AnOrder.SelectedCustomer = AnOrder.GetCustomerType("FACULTY");
                    case "2" -> AnOrder.SelectedCustomer = AnOrder.GetCustomerType("STUDENT");
                    case "3" -> AnOrder.SelectedCustomer = AnOrder.GetCustomerType("GUEST");
                }
                if(!inputSelectedCustomerType.equals("1") && !inputSelectedCustomerType.equals("2") && !inputSelectedCustomerType.equals("3")){
                    System.out.println("Invalid input");
                }
                else
                    StateMachine = States.SELECTION;
            }

            //Select product
            while (StateMachine == States.SELECTION){
                System.out.println("What would you like to drink?\r\nWe have:");
                AnOrder.ListOutDrinks();
                System.out.println("Press key # 1-" + AnOrder.SizeOfBeverageType +"\r\nPress 'c' to cancel order");
                String inputSelectedBeverageType = scanner.nextLine();

                //if adding more drinks, then modify this switch
                switch (inputSelectedBeverageType){
                    case "c" -> StateMachine = States.ENTRY;
                    case "1" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("COFFEE");
                    case "2" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("ESPRESSO");
                    case "3" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("AMERICANO");
                    case "4" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("COCOA");
                    case "5" -> AnOrder.SelectedBeverage = AnOrder.GetBeverageType("WATER");
                }
                if(AnOrder.SelectedBeverage == null){
                    System.out.println("Invalid choice. Press 1-" +AnOrder.SizeOfBeverageType +" or c to cancel");
                }
                else
                    StateMachine = States.DELIVERY;
            }

            //Pay, deliver order, & return to start
            while (StateMachine == States.DELIVERY){
                System.out.println("You have selected:\r\n"+AnOrder.SelectedBeverage+"\r\nConfirm, (y)es or (n)o:");

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
