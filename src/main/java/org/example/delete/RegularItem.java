package org.example.delete;

import org.example.models.Item;
import org.example.interfaces.AbstractItem;

public class RegularItem extends AbstractItem {

    public RegularItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isValid(item.quality)) {
            int decayRate = getUpdateRate();
            item.quality -= decayRate;
        }
    }
}
