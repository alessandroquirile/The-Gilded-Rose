package interfaces;

import org.example.utils.Constants;
import org.example.models.Item;
import org.example.factories.ItemUpdaterFactory;
import org.example.interfaces.DailyUpdater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyUpdaterTest {
    private Item item;
    private ItemUpdaterFactory factory;
    private DailyUpdater updater;
    private final String STRATEGY = "daily";

    @Test
    void sellInShouldDecreaseBy1EveryDay() {
        item = new Item(Constants.AGED_BRIE.getLabel(), 10, 30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        updater.updateSellIn(item);
        assertEquals(9, item.sellIn);
    }

    @Test
    void itemShouldBeValidWhenQualityIsBetween0And50() {
        item = new Item(Constants.AGED_BRIE.getLabel(), 10, 30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertTrue(updater.isValid(item.quality));
    }

    @Test
    void itemShouldNotBeValidWhenQualityIsLessThan0() {
        item = new Item(Constants.AGED_BRIE.getLabel(), 10, -1);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertFalse(updater.isValid(item.quality));
    }

    @Test
    void itemShouldNotBeValidWhenQualityIsLessMoreThan50() {
        item = new Item(Constants.AGED_BRIE.getLabel(), 10, 51);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertFalse(updater.isValid(item.quality));
    }

    @Test
    void itemShouldExpireWhenSellInIsNegative() {
        item = new Item(Constants.AGED_BRIE.getLabel(), -1,  30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertTrue(updater.hasExpired(item));
    }

    @Test
    void itemShouldNotExpireWhenSellInIsZero() {
        item = new Item(Constants.AGED_BRIE.getLabel(), 10, 0);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertFalse(updater.hasExpired(item));
    }

    @Test
    void itemShouldNotExpireWhenSellInIsPositive() {
        item = new Item(Constants.AGED_BRIE.getLabel(), 10, 1);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertFalse(updater.hasExpired(item));
    }


    @Test
    void updateRateShouldBe2IfExpired() {
        item = new Item(Constants.AGED_BRIE.getLabel(), -1, 30);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertEquals(2, updater.getUpdateRate(item));
    }

    @Test
    void updateRateShouldBe1IfNotExpired() {
        item = new Item(Constants.AGED_BRIE.getLabel(), 1, 1);
        factory = ItemUpdaterFactory.getInstance();
        updater = (DailyUpdater) factory.getUpdater(item, STRATEGY);
        assertEquals(1, updater.getUpdateRate(item));
    }
}