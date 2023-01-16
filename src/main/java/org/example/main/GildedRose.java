package org.example.main;

import org.example.factories.ItemUpdaterFactory;
import org.example.interfaces.ItemUpdater;
import org.example.models.Item;
import org.example.utils.ConfigFileReader;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateState() {
        ItemUpdaterFactory factory = ItemUpdaterFactory.getInstance();
        String strategy = ConfigFileReader.getProperty("update_strategy");
        for (Item item : items) {
            ItemUpdater updater = factory.getUpdater(item, strategy);
            updater.updateQuality(item);
            updater.updateSellIn(item);
        }
    }
}
