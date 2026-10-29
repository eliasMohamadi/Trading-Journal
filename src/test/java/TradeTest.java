import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TradeTest {

    @Test
    void testCalculatePnL() {
        // Arrange: instrument, direction, entry, exit, stopLoss, contracts, emotions
        Trade trade = new Trade(Trade.Instrument.MNQ, Trade.Direction.LONG,
                31005.25, 31025.5, 30090.0, 5, "Calm");

        // Act
        double pnl = trade.calculatePnL();

        // Assert: 5 contracts * (31025.5 - 31005.25) * $2 per point = 202.5
        assertEquals(202.5, pnl, 0.001);
    }
}
