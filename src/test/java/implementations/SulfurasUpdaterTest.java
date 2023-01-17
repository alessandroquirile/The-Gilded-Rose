package implementations;

import org.example.implementations.SulfurasUpdater;
import org.example.models.Item;
import org.example.utils.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasUpdaterTest {
    private final String sulfuras = Constants.SULFURAS.getLabel();
    private Item item;
    private SulfurasUpdater updater;

    @Test
    void qualityShouldBe80() {
        item = new Item(sulfuras, 30, 80);
        updater = new SulfurasUpdater(item);
        updater.updateQuality(item);
        assertEquals(80, updater.item.quality);
    }

    @Test
    void shouldNotBeSold() {
        item = new Item(sulfuras, 30, 80);
        updater = new SulfurasUpdater(item);
        updater.updateQuality(item);
        assertEquals(30, updater.item.sellIn);
    }
}