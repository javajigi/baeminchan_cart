package codesquad.domain;

import support.OptionalConsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        Optional<CartItem> maybeItem = findItem(item);
        Consumer<Optional<CartItem>> c = OptionalConsumer.of(
                existItem -> existItem.add(item),
                () -> items.add(item));
        c.accept(maybeItem);
    }

    private Optional<CartItem> findItem(CartItem item) {
        return items.stream().filter(i -> i.equals(item)).findFirst();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
