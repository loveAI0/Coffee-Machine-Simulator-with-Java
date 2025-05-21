class CoffeeMachineImproved {
     int waterAvailable = 400;
    int milkAvailable = 540;
    int beansAvailable = 120;
    int cupsAvailable = 9;
    int moneyAvailable = 550;


    public void showState() {
        System.out.printf("""
            The coffee machine has:
            %d ml of water
            %d ml of milk
            %d g of coffee beans
            %d disposable cups
            $%d of money
            """, waterAvailable, milkAvailable, beansAvailable, cupsAvailable, moneyAvailable);
    }

    public boolean makeCoffee(Coffee coffee) {
        if (waterAvailable < coffee.waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milkAvailable < coffee.milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beansAvailable < coffee.beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
           return false;
        }
        if (cupsAvailable < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }

        // Deduct resources
        waterAvailable -= coffee.waterNeeded;
        milkAvailable -= coffee.milkNeeded;
        beansAvailable -= coffee.beansNeeded;
        cupsAvailable -= 1;
        
        moneyAvailable += coffee.price;

        System.out.println("I have enough resources, making you a " + coffee.name + "!");
     
        return true;
       
    }
}

