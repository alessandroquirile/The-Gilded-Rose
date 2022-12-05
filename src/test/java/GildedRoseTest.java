import org.example.GildedRose;
import org.example.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    private Item[] items;
    private GildedRose app;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void sellInShouldBeUpdatedEveryDay() {
        items = new Item[] {
                new Item("", 30, 10),
                new Item("", 0, 10),
                new Item("", -1, 10)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, items[0].sellIn);
        assertEquals(-1, items[1].sellIn);
        assertEquals(-2, items[2].sellIn);
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
        assertEquals(8, items[0].quality);
        assertEquals(8, items[1].quality);
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

    @Test
    void backstagePassesShouldGain2QualityWhenSellInApproachesTo10() {
        items = new Item[] {
                new Item(BACKSTAGE_PASSES, 11, 30),
                new Item(BACKSTAGE_PASSES, 10, 30),
                new Item(BACKSTAGE_PASSES, 9, 30),
                new Item(BACKSTAGE_PASSES, 6, 50)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, items[0].quality);
        assertEquals(32, items[1].quality);
        assertEquals(32, items[2].quality);
        assertEquals(50, items[3].quality);
    }

    @Test
    void backstagePassesShouldGain3QualityWhenSellInApproachesTo5() {
        items = new Item[] {
                new Item(BACKSTAGE_PASSES, 6, 30),
                new Item(BACKSTAGE_PASSES, 5, 30),
                new Item(BACKSTAGE_PASSES, 4, 50),
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32, items[0].quality);
        assertEquals(33, items[1].quality);
        assertEquals(50, items[2].quality);
    }

    @Test
    void backstagePassesQualityShouldGoTo0AfterTheConcert() {
        items = new Item[] {
                new Item(BACKSTAGE_PASSES, 0, 30)
        };
        app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality);
    }

}