package codesquad.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
    @Test
    public void discountPrice_zeroSale() {
        Product product = new Product(1L)
                .setPrice(5000L)
                .setDiscount(0);
        assertThat(product.discountPrice()).isEqualTo(5000);
    }

    @Test
    public void discountPrice_tenPercentSale() {
        Product product = new Product(1L)
                .setPrice(5000L)
                .setDiscount(10);
        assertThat(product.discountPrice()).isEqualTo(4500);
    }
}
