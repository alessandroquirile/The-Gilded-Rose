package org.example;

public class AgedBrie extends AbstractItem {

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (isValid(item.quality)) {
            int improvementRate = hasExpired() ? 2 : 1;
            item.quality += improvementRate;
        }
    }
}