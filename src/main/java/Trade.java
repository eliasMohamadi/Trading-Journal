//Elias Mohamadi

//Trade Class that stores all the data for the users trades
public class Trade {
    
    //defining the enums
    public enum Instrument{
        MNQ(2),
        NQ(20),
        MES(5),
        ES(50),
        GC(100),
        MGC(10),
        MYM(0.5),
        YM(5);
        
        private final double valuePerPoint;
        
        Instrument(double valuePerPoint){
            this.valuePerPoint = valuePerPoint;
        }
        
        public double getValuePerPoint(){
            return valuePerPoint;
        }
    }
    
    
    public enum Direction{
        LONG,
        SHORT
    }
    
    //field declaration
    //enums
    private Direction direction;
    private Instrument instrument;
    
    private double entryPrice;
    private double exitPrice;
    private double stopLoss;
    private int numContracts;
    private String emotions;
    
    //Constructor
    public Trade(Instrument instrument, Direction direction, double entryPrice, double exitPrice,
                 double stopLoss, int numContracts, String emotions)
    {
        
        this.instrument = instrument;
        this.direction = direction;
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.stopLoss = stopLoss;
        this.numContracts = numContracts;
        this.emotions = emotions;
        
    }
    
    //Getters
    public Direction getDirection()
    {
        return direction;
    }
    
    public double getStopLoss()
    {
        return stopLoss;
    }
    
    public double getEntryPrice()
    {
        return entryPrice;
    }
    
    public double getExitPrice()
    {
        return exitPrice;
    }
    
    public int getNumContracts()
    {
        return numContracts;
    }
    
    public Instrument getInstrument()
    {
        return instrument;
    }
    
    public String getEmotions()
    {
        return emotions;
    }
    
    public double calculatePnL(){
        if(getDirection() == Direction.LONG)
        {
            return numContracts * (exitPrice - entryPrice) * instrument.valuePerPoint;
        }
        else
        {
            return numContracts * (entryPrice - exitPrice) * instrument.valuePerPoint;
        }
    }
    
    //--Setters + Validators
    public void setDirection(Direction direction) {
        if (direction == Direction.LONG || direction == Direction.SHORT) {
            this.direction = direction;
        }
    }
    
    public void setStopLoss(double stopLoss) {
        if (stopLoss >= 0) {
            if ((stopLoss > entryPrice) && (direction == Direction.SHORT)) {
                this.stopLoss = stopLoss;
            }
            if ((stopLoss < entryPrice) && (direction == Direction.LONG)) {
                this.stopLoss = stopLoss;
            }
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
        if((emotion != null) && (!emotion.isBlank())){
            this.emotions = emotion;
        }
    }
}