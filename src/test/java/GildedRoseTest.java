import org.example.GildedRose;
import org.example.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    private Item[] items;
    private GildedRose app;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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
    void agedBrieShouldGainQualityEveryDay() {
        items = new Item[] {
                new Item(AGED_BRIE, 30, 40)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(41, items[0].quality);
    }

    @Test
    void agedBrieQualityIsNeverAbove50() {
        items = new Item[] {
                new Item(AGED_BRIE, 30, 50)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void agedBrieShouldGainQualityTwiceFasterWhenSellInHasPassed() {
        items = new Item[] {
                new Item(AGED_BRIE, -1, 48)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void sulfurasShouldBeALegendaryItem() {
        items = new Item[] {
                new Item(SULFURAS, 30, 80)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

}