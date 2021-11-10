public class CoffeeMachine {

    enum States {ENTRY, SELECTION, DELIVERY, EXIT}
    States StateMachine = States.ENTRY;

    public CoffeeMachine() {

        //Identify student, faculty, or guest
        while (StateMachine == States.ENTRY){
            StateMachine = States.SELECTION;
        }

        //Select product
        while (StateMachine == States.SELECTION){
            StateMachine = States.DELIVERY;
        }

        //Pay, deliver order, & exit
        while (StateMachine == States.DELIVERY){
            StateMachine = States.EXIT;
        }
    }
}
