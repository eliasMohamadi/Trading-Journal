//Elias Mohamadi

import java.util.ArrayList;

public class TradeStatistics {
    
    public double totalPnl(ArrayList<Trade> trades) {
        double totalPNL = 0;
        for (int i = 0; i < trades.size(); i++) {
            Trade currentTrade = trades.get(i);
            totalPNL += currentTrade.calculatePnL();
        }
        return totalPNL;
    }
    
    public double winRate(ArrayList<Trade> trades) {
        //variables for winrate calculations
        double winrate = 0;
        int winningTrades = 0;
        int totalTrades = trades.size();
        
        if (trades.isEmpty()) {
            return 0;
        } else {
            for (Trade currentTrade : trades) {
                if (currentTrade.calculatePnL() > 0) {
                    winningTrades += 1;
                }
            }
            winrate = ((double) winningTrades / totalTrades) * 100;
        }
        return winrate;
    }
    
    public double averagePnl(ArrayList<Trade> trades) {
        double averagePNL = 0;
        if (trades.isEmpty()) {
            return 0;
        } else {
            for (Trade currentTrade : trades) {
                averagePNL += currentTrade.calculatePnL();
            }
            averagePNL = averagePNL / trades.size();
        }
        return averagePNL;
    }
    
    public double bestTrade(ArrayList<Trade> trades) {
        if (trades.isEmpty()) {
            return 0;
        } else {
            double bestTrade = trades.getFirst().calculatePnL();
            
            for (Trade currentTrade : trades) {
                if (currentTrade.calculatePnL() > bestTrade) {
                    bestTrade = currentTrade.calculatePnL();
                }
            }
            return bestTrade;
        }
    }
    public double worstTrade(ArrayList<Trade> trades) {
        if (trades.isEmpty()) {
            return 0;
        } else {
            double worstTrade = trades.getFirst().calculatePnL();
            
            for (Trade currentTrade : trades) {
                if (currentTrade.calculatePnL() < worstTrade) {
                    worstTrade = currentTrade.calculatePnL();
                }
            }
            return worstTrade;
        }
    }
}
