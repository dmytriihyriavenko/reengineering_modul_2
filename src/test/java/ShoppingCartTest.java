import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {


    @Test
    void test_appendFormatted() {
        StringBuilder sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Word", 0, 14);
        assertEquals("     Word      ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Word", 0, 15);
        assertEquals("     Word       ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Word", 0, 3);
        assertEquals("Wor ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Word", 1, 15);
        assertEquals("           Word ", sb.toString());
        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "Word", -1, 15);
        assertEquals("Word            ", sb.toString());
    }

    @Test
    void test_calculateDiscount() {
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 1));
        assertEquals(10, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 101));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 800));
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.REGULAR, 1000));

        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 500));
        assertEquals(73, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 30));
        assertEquals(71, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 10));
        assertEquals(70, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 9));
        assertEquals(70, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 1));

        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 20));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 10));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 1));

        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 500));
        assertEquals(53, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 30));
        assertEquals(51, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 10));
        assertEquals(50, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 9));
        assertEquals(50, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 2));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 1));
    }

}
