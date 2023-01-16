package org.example.implementations;

import org.example.models.Item;
import org.example.interfaces.DailyUpdater;

public class AgedBrieUpdater extends DailyUpdater {
    public Item item;

    public AgedBrieUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality(Item item) {
        if (isValid(item.quality)) {
            int improvementRate = getUpdateRate(item);
            item.quality += improvementRate;
        }
    }
}
