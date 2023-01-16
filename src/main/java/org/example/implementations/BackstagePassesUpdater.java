package org.example.implementations;

import org.example.interfaces.DailyUpdater;
import org.example.models.Item;

public class BackstagePassesUpdater extends DailyUpdater {
    public Item item;

    public BackstagePassesUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality(Item item) {
        if (isValid(item.quality)) {
            if (hasExpired(item))
                item.quality = 0;
            else
                item.quality += getUpdateRate(item);
        }
    }

    @Override
    public int getUpdateRate(Item item) {
        int daysToConcert = item.sellIn;
        if (daysToConcert <= 5)
            return 3;
        else if (daysToConcert <= 10)
            return 2;
        else
            return 1;
    }
}
