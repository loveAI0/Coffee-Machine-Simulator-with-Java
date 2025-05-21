public class Main {
    public static void main(String[] args) {
        CoffeeMachineImproved machine = new CoffeeMachineImproved();  // Initialize CoffeeMachine
        ActionHandler handler = new ActionHandler(machine);  // Pass CoffeeMachine to ActionHandler

        handler.processActions();  // Start handling user input
    }
}
