//Elias Mohamadi's Trading Journal

import java.util.*;

//main class that'll go on to execute the code
public class Main {
    //driver class that will display the CLI/Menu
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int userChoice = 0;
        
        //variable(s) + broad scope
        
        //FileManager object this is to do the loading and reading methods from the trades saved in the "trades.txt" file
        TradeFileManager fileManager = new TradeFileManager();
        //ArrayList to load old trades and store new trades
        ArrayList<Trade> trades = fileManager.loadTrade();
        //Initialize TradeStatistics
        TradeStatistics stats = new TradeStatistics();
        
        //welcome msg
        System.out.println("Welcome to Elias's Java Trading-Journal :)");
        
        //menu loop
        while(userChoice != 8){
            System.out.print("\n---MENU---\n" +
                    "1. Log new trade\n" +
                    "2. View trade(s)\n" +
                    "3. Total Trades\n" +
                    "4. Total Profit & Loss\n" +
                    "5. Winrate\n" +
                    "6. Average P&L\n" +
                    "7. Best and Worst Trade\n" +
                    "8. Turn Off journal\n" +
                    "Enter option: ");
            
            userChoice = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            //switch case to match users menu choice
            switch(userChoice){
                case 1: {
                    //variable(s) + scope
                    Trade.Direction direction = null;
                    Trade.Instrument instrument = null;
                    double entryPrice = 0;
                    double exitPrice = 0;
                    double stoploss = 0;
                    int numContracts = 0;
                    String emotions = "";
                    
                    System.out.println("Please fill the following.\n");
                    
                    boolean validInstrument = false;
                    while (!validInstrument) {
                        try {
                            System.out.print("Instrument: ");
                            String instrumentString = sc.nextLine();
                            
                            instrument = Trade.Instrument.valueOf(instrumentString.toUpperCase());
                            
                            //update valid input
                            validInstrument = true;
                        } catch (IllegalArgumentException e) { //error handling
                            System.out.print("Invalid instrument. Please try again.\n");
                        }
                    }
                    
                    boolean validDirection = false;
                    while (!validDirection) {
                        try {
                            System.out.print("Long or Short? ");
                            String directionString = sc.nextLine();
                            
                            direction = Trade.Direction.valueOf(directionString.toUpperCase());
                            
                            //update valid input
                            validDirection = true;
                        } catch (IllegalArgumentException e) { //error handling
                            System.out.print("Invalid direction. Please try again.\n");
                        }
                    }
                    
                    boolean validEntryPrice = false;
                    while (!validEntryPrice) {
                        try {
                            System.out.print("Entry price: ");
                            entryPrice = sc.nextDouble();
                            if (entryPrice >= 1) {
                                //update valid input
                                validEntryPrice = true;
                            } else {
                                System.out.println("Price must be at least 1. Try again.");
                            }
                        } catch (InputMismatchException e) { //error handling
                            System.out.println("Invalid entry price. Please try again.");
                            sc.nextLine();
                        }
                    }
                    
                    boolean validExitPrice = false;
                    while (!validExitPrice) {
                        try {
                            System.out.print("Exit price: ");
                            exitPrice = sc.nextDouble();
                            if (exitPrice >= 1) {
                                //update valid input
                                validExitPrice = true;
                            } else {
                                System.out.println("Price must be at least 1. Try again.");
                            }
                            
                        } catch (InputMismatchException e) { //error handling
                            System.out.println("Invalid exit price. Please try again.");
                            sc.nextLine();
                        }
                    }
                    
                    boolean validStopLoss = false;
                    while (!validStopLoss) {
                        try {
                            System.out.print("Stoploss: ");
                            stoploss = sc.nextDouble();
                            
                            if ((stoploss > entryPrice && direction == Trade.Direction.SHORT) || (stoploss < entryPrice && direction == Trade.Direction.LONG)) {
                                
                                if (stoploss > 0) {
                                    validStopLoss = true;
                                } else {
                                    System.out.println("Stoploss must be greater than 0.");
                                }
                            } else {
                                System.out.println("Invalid stoploss price. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid stoploss. Please try again.");
                            sc.nextLine();
                        }
                    }
                    
                    boolean validNumContracts = false;
                    while (!validNumContracts) {
                        try {
                            System.out.print("Number of contracts: ");
                            numContracts = sc.nextInt();
                            if (numContracts >= 1) {
                                validNumContracts = true;
                            } else {
                                System.out.println("Invalid number of contracts. Please try again.");
                            }
                            
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid number of contracts. Please try again.");
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();
                    
                    boolean validEmotions = false;
                    while (!validEmotions) {
                        System.out.print("Emotions: ");
                        emotions = sc.nextLine();
                        if (!emotions.isBlank()) {
                            validEmotions = true;
                        } else {
                            System.out.println("Enter a meaningful emotion.");
                        }
                    }
                    
                    //creates the trade object
                    Trade trade = new Trade(instrument, direction, entryPrice, exitPrice, stoploss, numContracts, emotions);
                    //adds the trade object to the ArrayList
                    trades.add(trade);
                    //saves the trade into a text file
                    fileManager.saveTrade(trade);
                    break;
                }
                case 2:
                    int tradeAccesser;
                    
                    if(trades.isEmpty()){
                        System.out.println("Sorry there are no trades yet.");
                    } else {
                        System.out.print("Enter the trade number that you wish to access: ");
                        tradeAccesser = sc.nextInt();
                        
                        System.out.println();
                        
                        if(tradeAccesser > trades.size() || tradeAccesser < 1){
                            System.out.println("Sorry but you haven't logged " +tradeAccesser+ " trades yet.");
                        } else {
                            Trade selectedTrade = trades.get(tradeAccesser - 1);
                            System.out.println("Instrument: " +selectedTrade.getInstrument());
                            System.out.println("You used a total of " +selectedTrade.getNumContracts()+ " contracts.");
                            System.out.println("You held your " +trades.get(tradeAccesser - 1).getDirection()+ " from the price of $"+selectedTrade.getEntryPrice() +" to the price of $" +selectedTrade.getExitPrice()+ ".");
                            System.out.println("Resulting in a total PnL of $" +selectedTrade.calculatePnL());
                        }
                    }
                    break;
                
                case 3:
                    System.out.println("Total Trades Logged: " +trades.size());
                    break;
                    
                case 4:
                    System.out.println("Total PnL: $" +stats.totalPnl(trades));
                    break;
                    
                case 5:
                    if(trades.isEmpty()){
                        System.out.println("Your list is empty.");
                    } else{
                        System.out.println("Your winrate is " +stats.winRate(trades)+ "%");
                    }
                    break;
                    
                case 6:
                    if(trades.isEmpty()){
                        System.out.println("Your list is empty.");
                    } else {
                        System.out.println("Your average trade PnL is $ " +stats.averagePnl(trades));
                    }
                    break;
                
                case 7:
                    if (trades.isEmpty()) {
                        System.out.println("Your list is empty.");
                    } else {
                        System.out.println("Best Trade: $" + stats.bestTrade(trades));
                        System.out.println("Worst Trade: $" + stats.worstTrade(trades));
                    }
                    break;
                    
                case 8:
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