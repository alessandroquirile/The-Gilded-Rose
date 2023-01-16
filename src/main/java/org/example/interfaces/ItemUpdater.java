package org.example.interfaces;

import org.example.models.Item;

public interface ItemUpdater {
    void updateQuality(Item item);

    void updateSellIn(Item item);
}
