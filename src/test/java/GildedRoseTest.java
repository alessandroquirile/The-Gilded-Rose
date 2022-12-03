import org.example.GildedRose;
import org.example.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    private Item[] items;
    private GildedRose app;

    @Test
    void sellInShouldBeUpdatedEveryDay() {
        items = new Item[] {
                new Item("", 30, 10)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, items[0].sellIn);
    }

    @Test
    void regularItemsShouldDegradeQualityByOneEveryDay() {
        items = new Item[] {
                new Item("", 30, 10)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    void regularItemsShouldDegradeTwiceFasterWhenSellInHasPassed() {
        items = new Item[] {
                new Item("", -1, 10),
                new Item("", 0, 10)
        };
        app = new GildedRose(items);
        app.updateQuality();
        for (Item item : items)
            assertEquals(8, item.quality);
    }

    @Test
    void regularItemsQualityShouldNotBeNegative() {
        items = new Item[] {
                new Item("", 30, 0)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }
}