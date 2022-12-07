package org.example;

public class ConjuredItem extends RegularItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int getRate() {
        return 2 * super.getRate();
    }
}
