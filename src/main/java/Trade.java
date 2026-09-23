public class Trade {
    private String instrument;
    
    public enum Direction{
        LONG,
        SHORT
    }
    private Direction direction;
    
    private double entryPrice;
    private double exitPrice;
    private double stopLoss;
    private int numContracts;
    private String emotions;
    
    public Trade(String instrument, Direction direction, double entryPrice,
                 double exitPrice, double stopLoss, int numContracts, String emotions){
        
        this.instrument = instrument;
        this.direction = direction;
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.stopLoss = stopLoss;
        this.numContracts = numContracts;
        this.emotions = emotions;
        
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public double getStopLoss() {
        return stopLoss;
    }
    
    public double getEntryPrice() {
        return entryPrice;
    }
    
    public double getExitPrice() {
        return exitPrice;
    }
    
    public int getNumContracts() {
        return numContracts;
    }
    
    public String getInstrument() {
        return instrument;
    }
    
    public String getEmotions() {
        return emotions;
    }
    
    
    //--Setters
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }
    
    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }
    
    public void setExitPrice(double exitPrice) {
        this.exitPrice = exitPrice;
    }
    
    public void setNumContracts(int numContracts) {
        this.numContracts = numContracts;
    }
    
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }
    
    public void setEmotions(String emotion) {
        this.emotions = emotion;
    }
}
