package delete;

import org.example.delete.AgedBrie;
import org.example.models.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTest {
    private static final String AGED_BRIE = "Aged Brie";
    private AgedBrie agedBrie;

    @Test
    void qualityShouldRaiseBy1WhenSellInIsPositive() {
        agedBrie = new AgedBrie(new Item(AGED_BRIE, 30, 40));
        agedBrie.updateQuality();
        assertEquals(41, agedBrie.item.quality);
    }

    @Test
    void qualityShouldRaiseBy1WhenSellInIsZero() {
        agedBrie = new AgedBrie(new Item(AGED_BRIE, 0, 40));
        agedBrie.updateQuality();
        assertEquals(41, agedBrie.item.quality);
    }

    @Test
    void qualityShouldRaiseBy2WhenSellIsIsNegative() {
        agedBrie = new AgedBrie(new Item(AGED_BRIE, -1, 40));
        agedBrie.updateQuality();
        assertEquals(42, agedBrie.item.quality);
    }

    @Test
    void qualityIsAtLeast0() {
        agedBrie = new AgedBrie(new Item(AGED_BRIE, 30, 0));
        agedBrie.updateQuality();
        assertEquals(0, agedBrie.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        agedBrie = new AgedBrie(new Item(AGED_BRIE, 30, 50));
        agedBrie.updateQuality();
        assertEquals(50, agedBrie.item.quality);
    }
}