package org.example;

public class BackstagePasses extends AbstractItem {

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isValid(item.quality)) {
            if (hasExpired())
                item.quality = 0;
            else
                item.quality += getRate();
        }
    }

    @Override
    public int getRate() {
        int daysToConcert = item.sellIn;
        if (daysToConcert <= 5)
            return 3;
        else if (daysToConcert <= 10)
            return 2;
        else
            return 1;
    }
}
