import java.util.Scanner;

class ActionHandler {
    private final CoffeeMachineImproved machine;
    private final Scanner scanner = new Scanner(System.in);
    private int count = 0;
    boolean statusPurchase = false;

    ActionHandler(CoffeeMachineImproved machine) {
        this.machine = machine;
    }

    public void processActions() {
        boolean running = true;

        while (running) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String choice = scanner.next();

            switch (choice) {
                case "buy":
                    System.out.println("Value of count " + count);
                    if(count == 10){
                        System.out.println("I need cleaning!");
                        count = 0;
                        
                    }
                    else{
                        handleBuy();
                    }
                   
                    break;
                case "fill":
                    handleFill();
                    break;
                case "take":
                    handleTake();
                    break;
                case "clean":
                    System.out.println("I have been cleaned.");
                    break;
                case "remaining":
                    machine.showState();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    private void handleBuy() {
        System.out.println("Choose your drink: 1 - Espresso, 2 - Latte, 3 - Cappuccino");

        int choice = scanner.nextInt();
        Coffee selectedCoffee = switch (choice) {
            case 1 -> new Coffee("Espresso", 250, 0, 16, 4);
            case 2 -> new Coffee("Latte", 350, 75, 20, 7);
            case 3 -> new Coffee("Cappuccino", 200, 100, 12, 6);
            default -> null;
        };

        if (selectedCoffee != null) {
            statusPurchase = machine.makeCoffee(selectedCoffee);
        } else {
            System.out.println("Invalid selection!");
        }

        if(selectedCoffee != null && statusPurchase){
            count++;
            System.out.println("count " + count);
        }
       
    }

    private void handleFill() {
        System.out.println("Write how many ml of water to add:");
        machine.waterAvailable += scanner.nextInt();

        System.out.println("Write how many ml of milk to add:");
        machine.milkAvailable += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans to add:");
        machine.beansAvailable += scanner.nextInt();

        System.out.println("Write how many disposable cups to add:");
        machine.cupsAvailable += scanner.nextInt();
    }

    private void handleTake() {
        System.out.println("I gave you $" + machine.moneyAvailable);
        machine.moneyAvailable = 0;
    }
}
