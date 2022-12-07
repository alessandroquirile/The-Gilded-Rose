package org.example;

public class GildedRose {
    public AbstractItem[] items;

    public GildedRose(AbstractItem[] items) {
        this.items = items;
    }

    public void launch() {
        for (AbstractItem item : items) {
            item.updateQuality();
            item.updateSellIn();
        }
    }
}
