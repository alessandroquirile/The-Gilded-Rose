package org.example.utils;

import org.example.models.Item;

public abstract class ItemChecker {
    public static boolean isSulfuras(Item item) {
        return InStock.SULFURAS.getFullName().equals(item.name);
    }

    public static boolean isRegular(Item item) {
        return InStock.REGULAR.getFullName().equals(item.name);
    }

    public static boolean isConjured(Item item) {
        return InStock.CONJURED.getFullName().equals(item.name);
    }

    public static boolean isAgedBrie(Item item) {
        return InStock.AGED_BRIE.getFullName().equals(item.name);
    }

    public static boolean isBackstagePasses(Item item) {
        return InStock.BACKSTAGE_PASSES.getFullName().equals(item.name);
    }
}
