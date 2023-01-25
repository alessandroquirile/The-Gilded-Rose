package implementations;

import org.example.implementations.SulfurasUpdater;
import org.example.models.Item;
import org.example.utils.InStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasUpdaterTest {
    private final String sulfuras = InStock.SULFURAS.getFullName();
    private Item item;
    private SulfurasUpdater updater;

    @BeforeEach
    void init() {
        item = new Item(sulfuras, 30, 80);
        updater = new SulfurasUpdater(item);
    }

    @Test
    void qualityShouldBe80() {
        updater.updateQuality(item);
        assertEquals(80, updater.item.quality);
    }

    @Test
    void sellInShouldNotDecrease() {
        updater.updateQuality(item);
        assertEquals(30, updater.item.sellIn);
    }
}