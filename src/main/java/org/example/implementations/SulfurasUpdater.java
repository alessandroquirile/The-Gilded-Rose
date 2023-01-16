package org.example.implementations;

import org.example.interfaces.DailyUpdater;
import org.example.models.Item;

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
