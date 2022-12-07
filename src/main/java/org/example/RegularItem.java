package org.example;

public class RegularItem extends AbstractItem {

    public RegularItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isValid(item.quality)) {
            int decayRate = hasExpired() ? 2 : 1;
            item.quality -= decayRate;
        }
    }
}
