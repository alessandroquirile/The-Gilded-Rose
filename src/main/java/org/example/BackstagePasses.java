package org.example;

public class BackstagePasses extends TradableItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (inValidRange(item.quality)) {
            int improvementRate = getRate();
            if (hasExpired())
                item.quality = 0;
            else
                item.quality += improvementRate;
        }
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
}
