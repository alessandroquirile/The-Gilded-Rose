package org.example;

public class GildedRose {
    public AbstractItem[] items;

    public GildedRose(AbstractItem[] items) {
        this.items = items;
    }

    public void updateState() {
        for (AbstractItem item : items) {
            item.updateQuality();
            item.updateSellIn();
        }
    }
}
