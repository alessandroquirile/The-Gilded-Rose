package org.example.exceptions;

import org.example.models.Item;

public class UpdaterNotAvailableYetException extends IllegalArgumentException {
    public UpdaterNotAvailableYetException(Item item) {
        super("An updater is not available yet for " + item.name);
    }
}
