package org.example;

public abstract class AbstractItem {
    protected static final int MIN_QUALITY = 0;
    protected static int MAX_QUALITY = 50;
    public Item item;

    public AbstractItem(Item item) {
        this.item = item;
    }

    protected abstract void updateQuality();

    protected final boolean isValid(int quality) {
        return quality > MIN_QUALITY && quality < MAX_QUALITY;
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected final boolean hasExpired() {
        return item.sellIn < 0;
    }
}
