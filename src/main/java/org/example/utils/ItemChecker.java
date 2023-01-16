package org.example.utils;

import org.example.models.Item;

public abstract class ItemChecker {
    public static boolean isSulfuras(Item item) {
        return Constants.SULFURAS.getLabel().equals(item.name);
    }

    public static boolean isRegular(Item item) {
        return Constants.REGULAR.getLabel().equals(item.name);
    }

    public static boolean isConjured(Item item) {
        return Constants.CONJURED.getLabel().equals(item.name);
    }

    public static boolean isAgedBrie(Item item) {
        return Constants.AGED_BRIE.getLabel().equals(item.name);
    }

    public static boolean isBackstagePasses(Item item) {
        return Constants.BACKSTAGE_PASSES.getLabel().equals(item.name);
    }
}
