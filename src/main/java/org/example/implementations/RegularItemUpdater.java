package org.example.implementations;

import org.example.interfaces.DailyUpdater;
import org.example.models.Item;

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
