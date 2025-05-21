import java.util.Scanner;
public class CoffeeMachine {
    static double waterAvailable = 400;
    static double milkAvailable = 540;
    static double beansAvailable = 120;
    static double cupsAvailable = 9;
    static double moneyAvailable = 550;

    static void State(){
        String msgInitial = """
            The coffee machine has:
            %.0f ml of water
            %.0f ml of milk
            %.0f g of coffee beans
            %.0f disposable cups
            $%.0f of money    
                """;

        System.out.println(String.format(msgInitial, CoffeeMachine.waterAvailable, CoffeeMachine.milkAvailable, CoffeeMachine.beansAvailable, CoffeeMachine.cupsAvailable, CoffeeMachine.moneyAvailable));
    }

    static void ActionMachine(){
        //initial state.
        State();

        System.out.println("Write action (buy, fill, take):");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        

        switch (choice) {
            case "buy":
                System.out.println("""
                    Choose your drink:
                    1 - Espresso
                    2 - Latte
                    3 - Cappuccino
                """);

            int menuChoice = input.nextInt();

            switch (menuChoice) {
                case 1 -> buyEspresso();
                case 2 -> buyLatte();
                case 3 -> buyCappuccino();
            }
            break;

            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                waterAvailable += input.nextDouble();

                System.out.println("Write how many ml of milk you want to add:");
                milkAvailable += input.nextDouble();

                System.out.println("Write how many grams of coffee beans you want to add:");
                beansAvailable += input.nextDouble();

                System.out.println("Write how many disposable cups you want to add:");
                cupsAvailable += input.nextDouble();

                State();

                break;
            case "take":
                System.out.println(String.format("I gave you $%.0f", moneyAvailable));
                moneyAvailable = 0;
                System.out.println(String.format("$%.0f of Money", moneyAvailable ));
                break;
            default:
                break;
        }

    }
    static void buyEspresso(){
        waterAvailable -= 250;
        beansAvailable -= 16;
        moneyAvailable += 4;
        cupsAvailable -= 1;
        State();
    }
    static void buyLatte(){
        waterAvailable -= 350;
        milkAvailable -= 75;
        beansAvailable -= 20;
        moneyAvailable += 7;
        cupsAvailable -= 1;
        State();
    }
    static void buyCappuccino(){
        waterAvailable -= 200;
         milkAvailable -= 100;
        beansAvailable -= 12;
        moneyAvailable += 6;
        cupsAvailable -= 1;
        State();
    }
    
}
