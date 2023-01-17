package interfaces;

import org.example.factories.ItemUpdaterFactory;
import org.example.interfaces.DailyUpdater;
import org.example.models.Item;
import org.example.utils.InStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyUpdaterTest {
    private static final String DAILY = "daily";
    private final String brie = InStock.AGED_BRIE.getFullName();
    private Item item;
    private ItemUpdaterFactory factory;
    private DailyUpdater updater;

    @Test
    void sellInShouldDecreaseBy1EveryDay() {
        item = new Item(brie, 10, 30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        updater.updateSellIn(item);
        assertEquals(9, item.sellIn);
    }

    @Test
    void itemShouldBeValidWhenQualityIsBetween0And50() {
        item = new Item(brie, 10, 30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertTrue(updater.isValid(item.quality));
    }

    @Test
    void itemShouldNotBeValidWhenQualityIsLessThan0() {
        item = new Item(brie, 10, -1);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertFalse(updater.isValid(item.quality));
    }

    @Test
    void itemShouldNotBeValidWhenQualityIsMoreThan50() {
        item = new Item(brie, 10, 51);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertFalse(updater.isValid(item.quality));
    }

    @Test
    void itemShouldExpireWhenSellInIsNegative() {
        item = new Item(brie, -1, 30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertTrue(updater.hasExpired(item));
    }

    @Test
    void itemShouldNotExpireWhenSellInIsZero() {
        item = new Item(brie, 10, 0);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertFalse(updater.hasExpired(item));
    }

    @Test
    void itemShouldNotExpireWhenSellInIsPositive() {
        item = new Item(brie, 10, 1);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertFalse(updater.hasExpired(item));
    }


    @Test
    void updateRateShouldBe2IfExpired() {
        item = new Item(brie, -1, 30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertEquals(2, updater.getUpdateRate(item));
    }

    @Test
    void updateRateShouldBe1IfNotExpired() {
        item = new Item(brie, 1, 1);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, DAILY);
        assertEquals(1, updater.getUpdateRate(item));
    }
}