package implementations;

import org.example.implementations.AgedBrieUpdater;
import org.example.models.Item;
import org.example.utils.InStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieUpdaterTest {
    private final String brie = InStock.AGED_BRIE.getFullName();
    private Item item;
    private AgedBrieUpdater updater;

    @Test
    void qualityShouldRaiseBy1WhenSellInIsPositive() {
        item = new Item(brie, 30, 40);
        updater = new AgedBrieUpdater(item);
        updater.updateQuality(item);
        assertEquals(41, updater.item.quality);
    }

    @Test
    void qualityShouldRaiseBy1WhenSellInIsZero() {
        item = new Item(brie, 0, 40);
        updater = new AgedBrieUpdater(item);
        updater.updateQuality(item);
        assertEquals(41, updater.item.quality);
    }

    @Test
    void qualityShouldRaiseBy2WhenSellIsIsNegative() {
        item = new Item(brie, -1, 40);
        updater = new AgedBrieUpdater(item);
        updater.updateQuality(item);
        assertEquals(42, updater.item.quality);
    }

    @Test
    void qualityIsAtLeast0() {
        item = new Item(brie, 30, 0);
        updater = new AgedBrieUpdater(item);
        updater.updateQuality(item);
        assertEquals(0, updater.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        item = new Item(brie, 30, 50);
        updater = new AgedBrieUpdater(item);
        updater.updateQuality(item);
        assertEquals(50, updater.item.quality);
    }
}