package codesquad.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class CartItem {
    private static final Logger log = LoggerFactory.getLogger(CartItem.class);

    private static final double SALES_PERCENTAGE_OVER_TEN = 0.05;
    private static final int ADDITIONAL_DISCOUNT_COUNT = 10;

    private final Product product;
    private int buyingCount;

    public CartItem(Product product, int buyingCount) {
        this.product = product;
        this.buyingCount = buyingCount;
    }

    public CartItem add(CartItem item) {
        buyingCount += item.buyingCount;
        return this;
    }

    public double getPrice() {
        double originalPrice = product.discountPrice() * buyingCount;
        log.debug("Original Price : {}", originalPrice);

        if (product.isOver20Discount() || !isAdditionalDiscount()) {
            return originalPrice;
        }

        return originalPrice - (originalPrice * SALES_PERCENTAGE_OVER_TEN);
    }

    private boolean isAdditionalDiscount() {
        return buyingCount >= ADDITIONAL_DISCOUNT_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(product, cartItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }
}
