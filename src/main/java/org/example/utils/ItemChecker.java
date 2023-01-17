package org.example.utils;

import org.example.models.Item;

public abstract class ItemChecker {
    public static boolean isSulfuras(Item item) {
        return Constants.SULFURAS.getFullName().equals(item.name);
    }

    public static boolean isRegular(Item item) {
        return Constants.REGULAR.getFullName().equals(item.name);
    }

    public static boolean isConjured(Item item) {
        return Constants.CONJURED.getFullName().equals(item.name);
    }

    public static boolean isAgedBrie(Item item) {
        return Constants.AGED_BRIE.getFullName().equals(item.name);
    }

    public static boolean isBackstagePasses(Item item) {
        return Constants.BACKSTAGE_PASSES.getFullName().equals(item.name);
    }
}
