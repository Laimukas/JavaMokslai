package Exercise24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasketTest {

    @Test
    void testAddToBasket_happyPath(){
        Basket basket = new Basket();
        basket.addToBasket();
        basket.addToBasket();
        basket.getNumberOfItems();
        assertEquals (2,basket.getNumberOfItems());
    }
    @Test
    void testAddToBasket_unhappyPath(){
        Basket basket = new Basket();
        for (int i=0;i<10;i++){
            basket.addToBasket();
        }
        BasketFullException basketFullException=assertThrows(BasketFullException.class,()->basket.addToBasket());
        assertEquals("per pilnas krepsys!",basketFullException.getMessage());
    }
    @Test
    void testRemoveToBasket_uhappyPath() {
        Basket basket = new Basket();
        BasketEmptyException basketEmptyException = assertThrows(BasketEmptyException.class, () -> basket.removeFromBasket());
        assertEquals("krepsys jau yra tuscias!", basketEmptyException.getMessage());
    }
}
