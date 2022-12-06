package org.example;

public class BackstagePasses extends AbstractItem {

    public BackstagePasses(Item item) {
        super(item);
        MAX_QUALITY = 50;
    }

    @Override
    protected void updateQuality() {
        if (qualityBetween(MIN_QUALITY, MAX_QUALITY)) {
            int improvementRate = getRate();
            if (hasExpired())
                item.quality = 0;
            else
                item.quality += improvementRate;
        }
    }

    private boolean qualityBetween(int minQuality, int maxQuality) {
        return item.quality > minQuality && item.quality < maxQuality;
    }

    private boolean hasExpired() {
        return item.sellIn < 0;
    }

    private int getRate() {
        int daysToConcert = item.sellIn;
        if (daysToConcert <= 5)
            return 3;
        else if (daysToConcert <= 10)
            return 2;
        else
            return 1;
    }

    @Override
    protected void updateSellIn() {
        item.sellIn--;
    }
}
