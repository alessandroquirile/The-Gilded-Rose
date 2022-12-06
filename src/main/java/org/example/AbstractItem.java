package org.example;

public abstract class AbstractItem {
    protected static final int MIN_QUALITY = 0;
    protected static int MAX_QUALITY = 50;
    protected Item item;

    public AbstractItem(Item item) {
        this.item = item;
    }

    protected abstract void updateQuality();
    protected abstract void updateSellIn();
}
