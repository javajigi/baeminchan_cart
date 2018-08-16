package codesquad.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartItemTest {
    @Test
    public void price_10개미만() {
        Product product = new Product(1L).setPrice(5000L).setDiscount(10);
        CartItem cartItem = new CartItem(product, 9);
        assertThat(cartItem.getPrice()).isEqualTo(40500.0);
    }

    @Test
    public void price_10개이상_할인율20미만() {
        Product product = new Product(1L).setPrice(5000L).setDiscount(0);
        CartItem cartItem = new CartItem(product, 10);
        assertThat(cartItem.getPrice()).isEqualTo(47500.0);
    }

    @Test
    public void price_10개이상_할인율20이상() {
        Product product = new Product(1L).setPrice(5000L).setDiscount(20);
        CartItem cartItem = new CartItem(product, 10);
        assertThat(cartItem.getPrice()).isEqualTo(40000.0);
    }
}
