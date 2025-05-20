import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        consoleOutput();
        requirementAnalysis();
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
}