package org.example;

public class GildedRose {
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateSellIn(item);
            item.quality = Math.max(item.quality, MIN_QUALITY);
        }
    }

    private void updateItemQuality(Item item) {
        if (isRegular(item))
            updateRegularItemQuality(item);
        else if (isAgedBrie(item))
            updateAgedBrieQuality(item);
        else if (isBackstagePasses(item)) {
            updateBackstagePassesQuality(item);
        } else if (isSulfuras(item)) {
            // nothing to do
        }
    }

    private void updateRegularItemQuality(Item item) {
        int decayRate = hasExpired(item)? 2 : 1;
        item.quality -= decayRate;
    }

    private boolean isRegular(Item item) {
        return !isAgedBrie(item) && !isBackstagePasses(item) && !isSulfuras(item);
    }

    private void updateSellIn(Item item) {
        if (!isSulfuras(item))
            item.sellIn -= 1;
    }

    private void updateBackstagePassesQuality(Item item) {
        if (isUnder(item.quality, MAX_QUALITY)) {
            if (hasExpired(item))
                item.quality = 0;
            else if (item.sellIn <= 5)
                item.quality += 3;
            else if (item.sellIn <= 10)
                item.quality += 2;
            else
                item.quality += 1;
        }
    }

    private void updateAgedBrieQuality(Item item) {
        if (isUnder(item.quality, MAX_QUALITY)) {
            int decayRate = hasExpired(item) ? 2 : 1;
            item.quality += decayRate;
        }
    }

    private boolean isUnder(int quality, int maxQuality) {
        return quality < maxQuality;
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private boolean isAgedBrie(Item item) {
        String AGED_BRIE = "Aged Brie";
        return item.name.equals(AGED_BRIE);
    }

    private boolean isSulfuras(Item item) {
        String SULFURAS = "Sulfuras, Hand of Ragnaros";
        return item.name.equals(SULFURAS);
    }

    private boolean isBackstagePasses(Item item) {
        String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
        return item.name.equals(BACKSTAGE_PASSES);
    }
}
