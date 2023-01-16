package delete;

import org.example.models.Item;
import org.example.delete.RegularItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegularItemTest {
    private static final String REGULAR = "Regular";
    private RegularItem regularItem;

    @Test
    void qualityShouldDegradeBy1WhenSellInIsPositive() {
        regularItem = new RegularItem(new Item(REGULAR, 30, 40));
        regularItem.updateQuality();
        assertEquals(39, regularItem.item.quality);
    }

    @Test
    void qualityShouldDegradeBy1WhenSellInIsZero() {
        regularItem = new RegularItem(new Item(REGULAR, 0, 40));
        regularItem.updateQuality();
        assertEquals(39, regularItem.item.quality);
    }

    @Test
    void qualityShouldDegradeBy2WhenSellInIsNegative() {
        regularItem = new RegularItem(new Item(REGULAR, -1, 40));
        regularItem.updateQuality();
        assertEquals(38, regularItem.item.quality);
    }

    @Test
    void qualityIsAtLeast0() {
        regularItem = new RegularItem(new Item(REGULAR, 30, 0));
        regularItem.updateQuality();
        assertEquals(0, regularItem.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        regularItem = new RegularItem(new Item(REGULAR, 30, 50));
        regularItem.updateQuality();
        assertEquals(50, regularItem.item.quality);
    }

}