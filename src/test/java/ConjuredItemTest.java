import org.example.ConjuredItem;
import org.example.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    private static final String CONJURED = "Conjured";
    private ConjuredItem conjuredItem;

    @Test
    void qualityShouldDegradeBy2WhenSellInIsPositive() {
        conjuredItem = new ConjuredItem(new Item(CONJURED, 30, 40));
        conjuredItem.updateQuality();
        assertEquals(38, conjuredItem.item.quality);
    }

    @Test
    void qualityShouldDegradeBy2WhenSellInIsZero() {
        conjuredItem = new ConjuredItem(new Item(CONJURED, 0, 40));
        conjuredItem.updateQuality();
        assertEquals(38, conjuredItem.item.quality);
    }

    @Test
    void qualityShouldDegradeBy4WhenSellInIsNegative() {
        conjuredItem = new ConjuredItem(new Item(CONJURED, -1, 40));
        conjuredItem.updateQuality();
        assertEquals(36, conjuredItem.item.quality);
    }

    @Test
    void qualityIsAtLeast0() {
        conjuredItem = new ConjuredItem(new Item(CONJURED, 30, 0));
        conjuredItem.updateQuality();
        assertEquals(0, conjuredItem.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        conjuredItem = new ConjuredItem(new Item(CONJURED, 30, 50));
        conjuredItem.updateQuality();
        assertEquals(50, conjuredItem.item.quality);
    }

}