package org.example.delete;

import org.example.models.Item;

public class ConjuredItem extends RegularItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int getUpdateRate() {
        return 2 * super.getUpdateRate();
    }
}
