package org.example.utils;

public enum InStock {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured"),
    REGULAR("Regular"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    private final String fullName;

    InStock(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
