//Elias Mohamadi's Trading Journal

import java.util.*;

//main class that'll go on to execute the code
public class Main {
    //driver class that will display the CLI/Menu
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        
        //for case 2, determines which trade to access
        int tradeAccesser;
        Trade.Direction direction = null;
        Trade.Instrument instrument = null;
        
        //FileManager object this is to do the loading and reading methods from the trades saved in the "trades.txt" file
        TradeFileManager fileManager = new TradeFileManager();
        //ArrayList to load old trades and store new trades
        ArrayList<Trade> trades = fileManager.loadTrade();
        
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
                    
                    //creates the trade object
                    Trade trade = new Trade(instrument, direction, entryPrice, exitPrice, stoploss, numContracts, emotions);
                    //adds the trade object to the ArrayList
                    trades.add(trade);
                    //saves the trade into a text file
                    fileManager.saveTrade(trade);
                    break;
                    
                case 2:
                    if(trades.isEmpty()){
                        System.out.println("Sorry there are no trades yet.");
                    } else {
                        System.out.print("Enter the trade number that you wish to access: ");
                        tradeAccesser = sc.nextInt();
                        
                        System.out.println();
                        
                        if(tradeAccesser > trades.size()){
                            System.out.println("Sorry but you haven't logged " +tradeAccesser+ " trades yet.");
                        } else {
                            System.out.println("You used a total of " +trades.get(tradeAccesser - 1).getNumContracts()+ " contracts.");
                            System.out.println("You held your " +trades.get(tradeAccesser - 1).getDirection()+ " to the price of $" +trades.get(tradeAccesser - 1).getExitPrice()+ ".");
                            System.out.println("Resulting in a total PnL of $" +trades.get(tradeAccesser - 1).calculatePnL());
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