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

    /*// Inutile siccome i regular item non migliorano mai
    @Test
    void regularItemsQualityShouldNotBeOver50() {
        items = new Item[] {
                new Item("", 30, 50)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }*/

    @Test
    void agedBrieGainsQualityEveryDay() {
        items = new Item[] {
                new Item("Aged Brie", 30, 40)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(41, items[0].quality);
    }

    @Test
    void agedBrieQualityIsNeverAbove50() {
        items = new Item[] {
                new Item("Aged Brie", 30, 50)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void agedBrieQualityGainsQualityTwiceFasterWhenSellInHasPassed() {
        items = new Item[] {
                new Item("Aged Brie", -1, 48)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

}