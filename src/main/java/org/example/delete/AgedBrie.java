package org.example.delete;

import org.example.models.Item;
import org.example.interfaces.AbstractItem;

public class AgedBrie extends AbstractItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isValid(item.quality)) {
            int improvementRate = getUpdateRate();
            item.quality += improvementRate;
        }
    }
}