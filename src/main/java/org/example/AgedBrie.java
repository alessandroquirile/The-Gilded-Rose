package org.example;

public class AgedBrie extends AbstractItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isValid(item.quality)) {
            int improvementRate = getRate();
            item.quality += improvementRate;
        }
    }
}