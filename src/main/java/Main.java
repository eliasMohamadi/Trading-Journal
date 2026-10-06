//Elias Mohamadi's Trading Journal

import java.util.*;

//main class that'll go on to execute the code
public class Main {
    //driver class that will display the CLI/Menu
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        //to keep track of trades
        int tradeNumber = 0;
        //for case 2, determines which trade to access
        int tradeAccesser;
        Trade.Direction direction = null;
        Trade.Instrument instrument = null;
        //Array to store the trades
        Trade[] trades = new Trade[100];
        //welcome msg
        System.out.println("Welcome to Elias's Java Trading-Journal :)");
        
        //menu loop
        while(userChoice != 3){
            System.out.print("\n---MENU---\n" +
                    "1. Log new trade\n" +
                    "2. View trade(s)\n" +
                    "3. Turn Off journal\n" +
                    "Enter option: ");
            
            userChoice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            //switch case to match users menu choice
            switch(userChoice){
                case 1:
                    System.out.println("Please fill the following.\n");
                    System.out.print("Instrument: ");
                    String instrumentString = sc.nextLine();
                    
                    instrument = Trade.Instrument.valueOf(instrumentString.toUpperCase());
                    
                    System.out.print("Long or Short? ");
                    String directionString = sc.nextLine();
                    
                    direction = Trade.Direction.valueOf(directionString.toUpperCase());
                    
                    System.out.print("Entry price: ");
                    double entryPrice = sc.nextDouble();
                    
                    System.out.print("Exit price: ");
                    double exitPrice = sc.nextDouble();
                    
                    System.out.print("Stoploss: ");
                    double stoploss = sc.nextDouble();
                    
                    System.out.print("Number of contracts: ");
                    int numContracts = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Emotions: ");
                    String emotions = sc.nextLine();
                    
                    trades[tradeNumber] = new Trade(instrument, direction, entryPrice, exitPrice, stoploss, numContracts, emotions);
                    tradeNumber += 1;
                    break;
                    
                case 2:
                    if(tradeNumber == 0){
                        System.out.println("Sorry there are no trades yet.");
                    } else {
                        System.out.print("Enter the trade number that you wish to access: ");
                        tradeAccesser = sc.nextInt();
                        
                        System.out.println();
                        
                        if(tradeAccesser > tradeNumber){
                            System.out.println("Sorry but you haven't logged " +tradeAccesser+ " trades yet.");
                        } else {
                            System.out.println("You used a total of " +trades[tradeAccesser-1].getNumContracts()+ " contracts.");
                            System.out.println("You held your " +trades[tradeAccesser-1].getDirection()+ " to the price of $" +trades[tradeAccesser-1].getExitPrice()+ ".");
                            System.out.println("Resulting in a total PnL of $" +trades[tradeAccesser-1].calculatePnL());
                        }
                    }
                    break;
                    
                case 3:
                    System.out.println("Shutting down...");
                    break;
                    
                default:
                    System.out.println("Sorry that option is not available yet.");
                    break;
                    
            }
        }
        //close that bih
        sc.close();
    }
}