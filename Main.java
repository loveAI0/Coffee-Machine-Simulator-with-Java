import java.util.Scanner;
public class Main{
    public static void main(String[] args){
       // consoleOutput();
        // requirementAnalysis();
        estimationOfServing();
    }
    static void consoleOutput(){
        String consoleOutput = """
                Starting to make a coffee
                Grinding coffee beans
                Boiling water
                Mixing boiled water with crushed coffee beans
                Pouring coffee into the cup
                Pouring some milk into the cup
                Coffee is ready!""";
        System.out.println(consoleOutput);
    }

    static void requirementAnalysis(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int coffeeCup = input.nextInt();

        System.out.println(String.format("For %d cups of coffee you will need:", coffeeCup));

        System.out.println(String.format("%d ml of water", 200 * coffeeCup));
        System.out.println(String.format("%d ml of milk", 50 * coffeeCup));
        System.out.println(String.format("%d g of coffee beans", 15 * coffeeCup));
    }

    static void estimationOfServing(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterQuantity = input.nextInt();
        double waterAvailable = (double) waterQuantity / 200 ; // for cups of coffee
        System.out.println(waterAvailable);

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkQuantity = input.nextInt();
        double milkAvailable = (double) milkQuantity / 50 ; // for cups of coffee
        System.out.println(milkAvailable);

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beansQuantity = input.nextInt();
        double beansAvailable = (double) beansQuantity / 15 ; // for cups of coffee
        System.out.println(beansAvailable);

        System.out.println("Write how many cups of coffee you will need:");
        double coffeeNeed = input.nextDouble();
        double coffeeAvailable = 0;
       
        if(waterAvailable < milkAvailable){
            if(waterAvailable < beansAvailable){
                coffeeAvailable = waterAvailable;
            }
            else{
                coffeeAvailable = beansAvailable;
            }
        }else{
            coffeeAvailable = milkAvailable;
        }
        

        if(Math.floor(coffeeAvailable) == Math.floor(coffeeNeed)){
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if(Math.floor(coffeeAvailable) > Math.floor(coffeeNeed)){
            System.out.println(String.format("Yes, I can make that amount of coffee (and even %.0f more than that)", Math.floor(coffeeAvailable) - Math.floor(coffeeNeed)));
        }

        else{
            System.out.println(String.format("No, I can make only %.0f cup(s) of coffee", Math.floor(coffeeAvailable)));
        }
        
        
    }
}