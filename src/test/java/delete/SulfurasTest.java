package delete;

import org.example.models.Item;
import org.example.delete.Sulfuras;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SulfurasTest {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private Sulfuras sulfuras;

    @Test
    void qualityShouldAlwaysBe80() {
        sulfuras = new Sulfuras(new Item(SULFURAS, 30, 80));
        sulfuras.updateSellIn();
        assertEquals(80, sulfuras.item.quality);
    }

    @Test
    void shouldNotBeSold() {
        sulfuras = new Sulfuras(new Item(SULFURAS, 30, 80));
        sulfuras.updateSellIn();
        assertEquals(30, sulfuras.item.sellIn);
    }

}