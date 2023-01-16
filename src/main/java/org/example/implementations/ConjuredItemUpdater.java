package org.example.implementations;

import org.example.models.Item;

public class ConjuredItemUpdater extends RegularItemUpdater {

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    public int getUpdateRate(Item item) {
        return 2 * super.getUpdateRate(item);
    }
}
