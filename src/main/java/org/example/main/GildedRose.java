package org.example.main;

import org.example.factories.ItemUpdaterFactory;
import org.example.interfaces.ItemUpdater;
import org.example.models.Item;
import org.example.utils.ConfigFileReader;

import java.util.List;

public class GildedRose {
    public List<Item> items;
    private ItemUpdaterFactory factory;
    private String strategy;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateState(List<Item> items) {
        factory = ItemUpdaterFactory.getInstance();
        strategy = ConfigFileReader.getProperty("update_strategy");
        for (Item item : items)
            updateState(item);
    }

    private void updateState(Item item) {
        ItemUpdater updater = factory.getUpdater(item, strategy);
        updater.updateQuality(item);
        updater.updateSellIn(item);
    }
}
