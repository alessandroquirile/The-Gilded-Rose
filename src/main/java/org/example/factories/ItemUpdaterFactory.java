package org.example.factories;

import org.example.exceptions.StrategyNotSupportedYetException;
import org.example.exceptions.UpdaterNotAvailableYetException;
import org.example.implementations.*;
import org.example.interfaces.DailyUpdater;
import org.example.interfaces.ItemUpdater;
import org.example.models.Item;

import static org.example.utils.ItemTypeChecker.*;

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

    private static DailyUpdater getDailyUpdater(Item item) {
        if (isAgedBrie(item))
            return new AgedBrieUpdater(item);
        else if (isBackstagePasses(item))
            return new BackstagePassesUpdater(item);
        else if (isConjured(item))
            return new ConjuredItemUpdater(item);
        else if (isRegular(item))
            return new RegularItemUpdater(item);
        else if (isSulfuras(item))
            return new SulfurasUpdater(item);
        throw new UpdaterNotAvailableYetException(item);
    }

    public ItemUpdater getUpdater(Item item, String strategy) {
        if (!isDaily(strategy))
            throw new StrategyNotSupportedYetException(strategy);
        return getDailyUpdater(item);
    }

    private boolean isDaily(String strategy) {
        return strategy.equals("daily");
    }
}
