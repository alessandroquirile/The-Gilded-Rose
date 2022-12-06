import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    private static final String REGULAR = "Regular";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private TradableItem[] items;
    private GildedRose app;

    @Test
    void sellInShouldBeUpdatedEveryDay() {
        items = new TradableItem[]{
                new RegularItem(new Item(REGULAR, 30, 10)),
                new RegularItem(new Item(REGULAR, 0, 10)),
                new RegularItem(new Item(REGULAR, -1, 10))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(29, items[0].item.sellIn);
        assertEquals(-1, items[1].item.sellIn);
        assertEquals(-2, items[2].item.sellIn);
    }

    @Test
    void regularItemsShouldDegradeQualityByOneEveryDay() {
        items = new TradableItem[]{
                new RegularItem(new Item(REGULAR, 30, 10))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(9, items[0].item.quality);
    }

    @Test
    void regularItemsShouldDegradeTwiceFasterWhenSellInHasPassed() {
        items = new TradableItem[]{
                new RegularItem(new Item(REGULAR, -1, 10)),
                new RegularItem(new Item(REGULAR, 0, 10)),
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(8, items[0].item.quality);
        assertEquals(9, items[1].item.quality);
    }

    @Test
    void regularItemsQualityShouldNotBeNegative() {
        items = new TradableItem[]{
                new RegularItem(new Item(REGULAR, 30, 0))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(0, items[0].item.quality);
    }

    @Test
    void agedBrieShouldGainQualityEveryDay() {
        items = new TradableItem[]{
                new AgedBrie(new Item(AGED_BRIE, 30, 40))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(41, items[0].item.quality);
    }

    @Test
    void agedBrieQualityIsNeverAbove50() {
        items = new TradableItem[]{
                new AgedBrie(new Item(AGED_BRIE, 30, 50))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(50, items[0].item.quality);
    }

    @Test
    void agedBrieShouldGainQualityTwiceFasterWhenSellInHasPassed() {
        items = new TradableItem[]{
                new AgedBrie(new Item(AGED_BRIE, -1, 48))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(50, items[0].item.quality);
    }

    // Todo nella classe sulfuras:
    /*@Test
    void sulfurasShouldBeALegendaryItem() {
        items = new AbstractItem[] {
                new Sulfuras(new Item(SULFURAS, 30, 80))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(30, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }*/

    @Test
    void backstagePassesShouldGain2QualityWhenSellInApproachesTo10() {
        items = new TradableItem[]{
                new BackstagePasses(new Item(BACKSTAGE_PASSES, 11, 30)),
                new BackstagePasses(new Item(BACKSTAGE_PASSES, 10, 30)),
                new BackstagePasses(new Item(BACKSTAGE_PASSES, 9, 30)),
                new BackstagePasses(new Item(BACKSTAGE_PASSES, 6, 50))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(31, items[0].item.quality);
        assertEquals(32, items[1].item.quality);
        assertEquals(32, items[2].item.quality);
        assertEquals(50, items[3].item.quality);
    }

    @Test
    void backstagePassesShouldGain3QualityWhenSellInApproachesTo5() {
        items = new TradableItem[]{
                new BackstagePasses(new Item(BACKSTAGE_PASSES, 6, 30)),
                new BackstagePasses(new Item(BACKSTAGE_PASSES, 5, 30)),
                new BackstagePasses(new Item(BACKSTAGE_PASSES, 4, 50))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(32, items[0].item.quality);
        assertEquals(33, items[1].item.quality);
        assertEquals(50, items[2].item.quality);
    }

    @Test
    void backstagePassesQualityShouldGoTo0AfterTheConcert() {
        items = new TradableItem[]{
                new BackstagePasses(new Item(BACKSTAGE_PASSES, -1, 30))
        };
        app = new GildedRose(items);
        app.launch();
        assertEquals(0, items[0].item.quality);
    }
}