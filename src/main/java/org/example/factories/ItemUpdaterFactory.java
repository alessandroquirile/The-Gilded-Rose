package org.example.factories;

import org.example.models.Item;
import org.example.exceptions.StrategyNotSupportedYetException;
import org.example.exceptions.UpdaterNotAvailableYetException;
import org.example.implementations.*;
import org.example.interfaces.ItemUpdater;

public class ItemUpdaterFactory {
    private static ItemUpdaterFactory instance;

    private ItemUpdaterFactory() {
        instance = null;
    }

    public static synchronized ItemUpdaterFactory getInstance() {
        if (instance == null)
            instance = new ItemUpdaterFactory();
        return instance;
    }

    public ItemUpdater getUpdater(Item item, String strategy) {
        if (!strategy.equals("daily"))
            throw new StrategyNotSupportedYetException(strategy);
        return switch (item.name) {
            case "Aged Brie" -> new AgedBrieUpdater(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassesUpdater(item);
            case "Conjured" -> new ConjuredItemUpdater(item);
            case "Regular" -> new RegularItemUpdater(item);
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasUpdater(item);
            default -> throw new UpdaterNotAvailableYetException(item);
        };
    }
}
