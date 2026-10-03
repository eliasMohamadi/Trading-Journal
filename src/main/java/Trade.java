public class Trade {
    
    public enum Instrument{
        MNQ,
        NQ,
        MES,
        ES,
        GC,
        MGC,
        MYM,
        YM
    }
    
    public enum Direction{
        LONG,
        SHORT
    }
    
    //enums
    private Direction direction;
    private Instrument instrument;
    
    private double entryPrice;
    private double exitPrice;
    private double stopLoss;
    private int numContracts;
    private String emotions;
    
    public Trade(Instrument instrument, Direction direction, double entryPrice,
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
    
    public Instrument getInstrument() {
        return instrument;
    }
    
    public String getEmotions() {
        return emotions;
    }
    
    
    //--Setters
    public void setDirection(Direction direction) {
        if (direction == Direction.LONG || direction == Direction.SHORT) {
            this.direction = direction;
        }
    }
    
    public void setStopLoss(double stopLoss) {
            if(stopLoss >= 0){
                this.stopLoss = stopLoss;
            }
    }
    
    public void setEntryPrice(double entryPrice) {
        if(entryPrice > 0) {
            this.entryPrice = entryPrice;
        }
    }
    
    public void setExitPrice(double exitPrice) {
        if (exitPrice > 0) {
            this.exitPrice = exitPrice;
        }
    }
    
    public void setNumContracts(int numContracts) {
        if (numContracts > 0) {
            this.numContracts = numContracts;
        }
    }
    
    public void setInstrument(Instrument instrument) {
        if (instrument != null) {
            this.instrument = instrument;
        }
    }
    
    public void setEmotions(String emotion) {
        if((emotion != null) &&( !emotion.isBlank())){
            this.emotions = emotion;
        }
    }
}