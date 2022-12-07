import org.example.BackstagePasses;
import org.example.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private BackstagePasses backstagePasses;

    @Test
    void qualityShouldRaiseBy1WhenSellInIsMoreThan10() {
        backstagePasses = new BackstagePasses(new Item(BACKSTAGE_PASSES, 11, 30));
        backstagePasses.updateQuality();
        assertEquals(31, backstagePasses.item.quality);
    }

    @Test
    void qualityShouldRaiseBy2WhenSellInIs10_orLess() {
        backstagePasses = new BackstagePasses(new Item(BACKSTAGE_PASSES, 10, 30));
        backstagePasses.updateQuality();
        assertEquals(32, backstagePasses.item.quality);
    }

    @Test
    void qualityShouldRaiseBy3WhenSellInIs5_orLess() {
        backstagePasses = new BackstagePasses(new Item(BACKSTAGE_PASSES, 5, 30));
        backstagePasses.updateQuality();
        assertEquals(33, backstagePasses.item.quality);
    }

    @Test
    void qualityIsAtLeast0() {
        backstagePasses = new BackstagePasses(new Item(BACKSTAGE_PASSES, 30, 0));
        backstagePasses.updateQuality();
        assertEquals(0, backstagePasses.item.quality);
    }

    @Test
    void qualityIsAtMost50() {
        backstagePasses = new BackstagePasses(new Item(BACKSTAGE_PASSES, 30, 50));
        backstagePasses.updateQuality();
        assertEquals(50, backstagePasses.item.quality);
    }
}