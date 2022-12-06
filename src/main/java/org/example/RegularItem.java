package org.example;

public class RegularItem extends AbstractItem {

    public RegularItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        int decayRate = hasExpired(item)? 2 : 1;
        item.quality -= decayRate;
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    @Override
    protected void updateSellIn() {
        item.sellIn --;
    }
}
