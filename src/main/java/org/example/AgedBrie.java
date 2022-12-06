package org.example;

public class AgedBrie extends AbstractItem {

    public AgedBrie(Item item) {
        super(item);
        MAX_QUALITY = 50;
    }

    @Override
    protected void updateQuality() {
        if (qualityBetween(MIN_QUALITY, MAX_QUALITY)) {
            int improvementRate = getRate();
            item.quality += improvementRate;
        }
    }

    @Override
    protected void updateSellIn() {
        item.sellIn --;
    }

    private int getRate() {
        return hasExpired() ? 2 : 1;
    }

    private boolean qualityBetween(int minQuality, int maxQuality) {
        return item.quality > minQuality && item.quality < maxQuality;
    }

    private boolean hasExpired() {
        return item.sellIn < 0;
    }
}
