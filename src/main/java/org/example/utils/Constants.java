package org.example.utils;

public enum Constants {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured"),
    REGULAR("Regular"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    private final String label;

    Constants(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
