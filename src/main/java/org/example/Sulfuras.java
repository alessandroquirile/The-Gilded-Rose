package org.example;

public class Sulfuras extends AbstractItem {

    public Sulfuras(Item item) {
        super(item);
        MAX_QUALITY = 80;
    }

    @Override
    protected void updateQuality() {
        item.quality = MAX_QUALITY;
    }

    @Override
    protected void updateSellIn() {
         // nothing to do
    }
}
