package org.example.interfaces;

import org.example.models.Item;

public abstract class DailyUpdater implements ItemUpdater {
    public static final int MIN_QUALITY = 0;
    public static int MAX_QUALITY = 50;

    public abstract void updateQuality(Item item);

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    public boolean isValid(int quality) {
        return quality > MIN_QUALITY && quality < MAX_QUALITY;
    }

    public boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    public int getUpdateRate(Item item) {
        return hasExpired(item) ? 2 : 1;
    }
}
