package org.example.main;

import org.example.factories.ItemUpdaterFactory;
import org.example.interfaces.ItemUpdater;
import org.example.models.Item;
import org.example.utils.ConfigFileReader;

import java.util.List;

public class GildedRose {
    public List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateState(List<Item> items) {
        ItemUpdaterFactory factory = ItemUpdaterFactory.getInstance();
        String strategy = ConfigFileReader.getProperty("update_strategy");
        for (Item item : items) {
            ItemUpdater updater = factory.getUpdater(item, strategy);
            updater.updateQuality(item);
            updater.updateSellIn(item);
        }
    }

}
