package org.example.implementations;

import org.example.models.Item;
import org.example.interfaces.DailyUpdater;

public class RegularItemUpdater extends DailyUpdater {
    public Item item;

    public RegularItemUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality(Item item) {
        if (isValid(item.quality)) {
            int decayRate = getUpdateRate(item);
            item.quality -= decayRate;
        }
    }
}
