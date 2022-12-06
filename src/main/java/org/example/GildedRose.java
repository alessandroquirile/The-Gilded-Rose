package org.example;

public class GildedRose {
    public TradableItem[] items;

    public GildedRose(TradableItem[] items) {
        this.items = items;
    }

    public void launch() {
        for (TradableItem item : items) {
            item.updateQuality();
            item.updateSellIn();
        }
    }
}
