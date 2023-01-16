package org.example.implementations;

import org.example.models.Item;
import org.example.interfaces.DailyUpdater;

public class SulfurasUpdater extends DailyUpdater {
    private static final int MAX_QUALITY = 80;
    public Item item;

    public SulfurasUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality(Item item) {
        item.quality = MAX_QUALITY;
    }

    @Override
    public void updateSellIn(Item item) {
        // do nothing
    }
}
