package org.example;

public class ConjuredItem extends RegularItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int getUpdateRate() {
        return 2 * super.getUpdateRate();
    }
}
