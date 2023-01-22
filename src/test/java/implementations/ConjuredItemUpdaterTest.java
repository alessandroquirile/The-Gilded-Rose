package implementations;

import org.example.implementations.ConjuredItemUpdater;
import org.example.models.Item;
import org.example.utils.InStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemUpdaterTest {
    private final String conjured = InStock.CONJURED.getFullName();
    private Item item;
    private ConjuredItemUpdater updater;

    @Test
    void qualityShouldDecreaeBy2WhenSellInIsPositive() {
        item = new Item(conjured, 30, 40);
        updater = new ConjuredItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(38, updater.item.quality);
    }

    @Test
    void qualityShouldDecreaseBy2WhenSellInIsZero() {
        item = new Item(conjured, 0, 40);
        updater = new ConjuredItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(38, updater.item.quality);
    }

    @Test
    void qualityShouldDecreaseBy4WhenSellInIsNegative() {
        item = new Item(conjured, -1, 40);
        updater = new ConjuredItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(36, updater.item.quality);
    }

    @Test
    void qualityIsAtLeast0() {
        item = new Item(conjured, 30, 0);
        updater = new ConjuredItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(0, updater.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        item = new Item(conjured, 30, 50);
        updater = new ConjuredItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(50, updater.item.quality);
    }
}