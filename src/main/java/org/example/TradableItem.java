package org.example;

public abstract class TradableItem extends AbstractItem {
    protected static final int MIN_QUALITY = 0;
    protected static final int MAX_QUALITY = 50;

    public TradableItem(Item item) {
        super(item);
    }

    protected abstract void updateQuality();

    protected final boolean isValid(int quality) {
        return quality > TradableItem.MIN_QUALITY && quality < TradableItem.MAX_QUALITY;
    }

    protected final void updateSellIn() {
        item.sellIn--;
    }

    protected final boolean hasExpired() {
        return item.sellIn < 0;
    }
}
