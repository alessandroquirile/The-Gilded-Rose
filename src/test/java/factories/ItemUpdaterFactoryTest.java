package factories;

import org.example.exceptions.StrategyNotSupportedYetException;
import org.example.exceptions.UpdaterNotAvailableYetException;
import org.example.factories.ItemUpdaterFactory;
import org.example.implementations.*;
import org.example.interfaces.DailyUpdater;
import org.example.interfaces.ItemUpdater;
import org.example.models.Item;
import org.example.utils.InStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemUpdaterFactoryTest {
    private final String STRATEGY = "daily";
    private final String agedBrie = InStock.AGED_BRIE.getFullName();
    private final String backstagePasses = InStock.BACKSTAGE_PASSES.getFullName();
    private final String conjured = InStock.CONJURED.getFullName();
    private final String regular = InStock.REGULAR.getFullName();
    private final String sulfuras = InStock.SULFURAS.getFullName();
    private Item item;
    private ItemUpdaterFactory factory;
    private ItemUpdater updater;

    @BeforeEach
    void init() {
        factory = ItemUpdaterFactory.getInstance();
    }

    @Test
    void getProperUpdaterForDailyUpdate() {
        item = new Item(agedBrie, 0, 0);
        updater = factory.getUpdater(item, STRATEGY);
        assert (updater instanceof DailyUpdater);
    }

    @Test
    void shouldThrowTechnologyNotSupportedYetExceptionWhenStrategyIsNotDaily() {
        item = new Item(agedBrie, 0, 0);
        assertThrows(
                StrategyNotSupportedYetException.class,
                () -> factory.getUpdater(item, "Any other")
        );
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenItemHasNoUpdater() {
        item = new Item("Any other", 0, 0);
        assertThrows(
                UpdaterNotAvailableYetException.class,
                () -> factory.getUpdater(item, STRATEGY)
        );
    }

    @Test
    void getProperUpdaterForAgedBrie() {
        item = new Item(agedBrie, 0, 0);
        updater = factory.getUpdater(item, STRATEGY);
        assert (updater instanceof AgedBrieUpdater);
    }

    @Test
    void getProperUpdaterForBackstagePasses() {
        item = new Item(backstagePasses, 0, 0);
        updater = factory.getUpdater(item, STRATEGY);
        assert (updater instanceof BackstagePassesUpdater);
    }

    @Test
    void getProperUpdaterForConjuredItem() {
        item = new Item(conjured, 0, 0);
        updater = factory.getUpdater(item, STRATEGY);
        assert (updater instanceof ConjuredItemUpdater);
    }

    @Test
    void getProperUpdaterForRegularItem() {
        item = new Item(regular, 0, 0);
        updater = factory.getUpdater(item, STRATEGY);
        assert (updater instanceof RegularItemUpdater);
    }

    @Test
    void getProperUpdaterForSulfuras() {
        item = new Item(sulfuras, 0, 80);
        updater = factory.getUpdater(item, STRATEGY);
        assert (updater instanceof SulfurasUpdater);
    }
}
