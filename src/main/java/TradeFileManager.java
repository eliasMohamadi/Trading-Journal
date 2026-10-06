//Elias Mohamadi
import java.io.*;
import java.util.ArrayList;

public class TradeFileManager {
    //how the program is going to store all the trades (persistent memory)
    public void saveTrade(Trade trade){
        File file = new File("trades.txt");
        
        try{
            FileWriter writer = new FileWriter(file, true);
            
            writer.write(trade.getInstrument() + "," +
                    trade.getDirection() + "," +
                    trade.getEntryPrice() + "," +
                    trade.getExitPrice() + "," +
                    trade.getStopLoss() + "," +
                    trade.getNumContracts() + "," +
                    trade.getEmotions());
            
            writer.write("\n");
            
            writer.close();
        } catch(IOException e){
            System.out.println("Error writing trade to file.");
        }
    }
    
    public ArrayList<Trade> loadTrade(){
        File file = new File("trades.txt");
        
        try{
            //FileReader reads characters and when paired with a BufferedReader it conveniently reads line by line
            FileReader reader  = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            
            String line;
            //creating the Trade ArrayList
            ArrayList<Trade> trades = new ArrayList<>();
            
            while((line = bufferedReader.readLine()) != null){
                String[] fields = line.split(",");
                
                //assigning each part of the required Trade fields their specific data
                Trade.Instrument instrument = Trade.Instrument.valueOf(fields[0]);
                Trade.Direction direction = Trade.Direction.valueOf(fields[1]);
                double entryPrice = Double.parseDouble(fields[2]);
                double exitPrice = Double.parseDouble(fields[3]);
                double stopLoss = Double.parseDouble(fields[4]);
                int numContracts = Integer.parseInt(fields[5]);
                String emotions = fields[6];
                
                //creating the Trade object and add them to the ArrayList
                Trade trade = new Trade(instrument, direction, entryPrice, exitPrice, stopLoss, numContracts, emotions);
                trades.add(trade);
            }
            return trades;
            
        } catch(IOException e){
            System.out.println("Error reading trades from file.");
            return new ArrayList<>();
        }
    }
}
