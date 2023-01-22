package implementations;

import org.example.implementations.BackstagePassesUpdater;
import org.example.models.Item;
import org.example.utils.InStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesUpdaterTest {
    private final String backstagePasses = InStock.BACKSTAGE_PASSES.getFullName();
    private Item item;
    private BackstagePassesUpdater updater;

    @Test
    void qualityShouldIncreaseBy1WhenSellInIsMoreThan10() {
        item = new Item(backstagePasses, 11, 30);
        updater = new BackstagePassesUpdater(item);
        updater.updateQuality(item);
        assertEquals(31, updater.item.quality);
    }

    @Test
    void qualityShouldIncreaseBy2WhenSellInIs10_orLess() {
        item = new Item(backstagePasses, 10, 30);
        updater = new BackstagePassesUpdater(item);
        updater.updateQuality(item);
        assertEquals(32, updater.item.quality);
    }

    @Test
    void qualityShouldIncreaseBy3WhenSellInIs5_orLess() {
        item = new Item(backstagePasses, 5, 30);
        updater = new BackstagePassesUpdater(item);
        updater.updateQuality(item);
        assertEquals(33, updater.item.quality);
    }

    @Test
    void qualityIsAtLeast0() {
        item = new Item(backstagePasses, 30, 0);
        updater = new BackstagePassesUpdater(item);
        updater.updateQuality(item);
        assertEquals(0, updater.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        item = new Item(backstagePasses, 30, 50);
        updater = new BackstagePassesUpdater(item);
        updater.updateQuality(item);
        assertEquals(50, updater.item.quality);
    }
}