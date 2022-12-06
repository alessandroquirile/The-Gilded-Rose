package org.example;

public class ItemFactory {
    private static ItemFactory instance;

    private ItemFactory() {
        instance = null;
    }

    public static synchronized ItemFactory getInstance() {
        if (instance == null)
            instance = new ItemFactory();
        return instance;
    }

    public AbstractItem getAbstractItem(Item item) {
        final String AGED_BRIE = "Aged Brie";
        final String SULFURAS = "Sulfuras, Hand of Ragnaros";
        final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
        return switch (item.name) {
            case AGED_BRIE -> new AgedBrie(item);
            case SULFURAS -> new Sulfuras(item);
            case BACKSTAGE_PASSES -> new BackstagePasses(item);
            default -> new RegularItem(item);
        };
    }
}
