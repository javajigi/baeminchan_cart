package codesquad.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {
    @Test
    public void 서로_다른_상품_등록() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(new Product(1L), 2));
        cart.addItem(new CartItem(new Product(2L), 1));
        assertThat(cart.getItems()).hasSize(2);
    }

    @Test
    public void 같은_상품_등록() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(new Product(1L), 2));
        cart.addItem(new CartItem(new Product(1L), 1));
        cart.addItem(new CartItem(new Product(2L), 1));
        assertThat(cart.getItems()).hasSize(2);
    }
}
