package org.example;

public abstract class AbstractItem {
    protected static final int MIN_QUALITY = 0;
    protected static int MAX_QUALITY = 50;
    public Item item;

    public AbstractItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();

    public final boolean isValid(int quality) {
        return quality > MIN_QUALITY && quality < MAX_QUALITY;
    }

    public void updateSellIn() {
        item.sellIn--;
    }

    public final boolean hasExpired() {
        return item.sellIn < 0;
    }

    public int getRate() {
        return hasExpired() ? 2 : 1;
    }
}
