package implementations;

import org.example.implementations.RegularItemUpdater;
import org.example.models.Item;
import org.example.utils.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularItemUpdaterTest {
    private final String regular = Constants.REGULAR.getLabel();
    private Item item;
    private RegularItemUpdater updater;

    @Test
    void qualityShouldDegradeBy1WhenSellInIsPositive() {
        item = new Item(regular, 30, 40);
        updater = new RegularItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(39, updater.item.quality);
    }

    @Test
    void qualityShouldDegradeBy1WhenSellInIsZero() {
        item = new Item(regular, 0, 40);
        updater = new RegularItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(39, updater.item.quality);

    }

    @Test
    void qualityShouldDegradeBy2WhenSellInIsNegative() {
        item = new Item(regular, -1, 40);
        updater = new RegularItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(38, updater.item.quality);

    }

    @Test
    void qualityIsAtLeast0() {
        item = new Item(regular, 30, 0);
        updater = new RegularItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(0, updater.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        item = new Item(regular, 30, 50);
        updater = new RegularItemUpdater(item);
        updater.updateQuality(item);
        assertEquals(50, updater.item.quality);
    }
}