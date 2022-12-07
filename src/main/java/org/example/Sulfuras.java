package org.example;

public class Sulfuras extends AbstractItem {
    private static final int MAX_QUALITY = 80;

    public Sulfuras(Item item) {
        super(item);
        item.quality = MAX_QUALITY;
    }

    @Override
    public void updateQuality() {
        // do nothing
    }

    @Override
    public void updateSellIn() {
        // do nothing
    }
}
