package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {

        Product apple = new SimpleProduct("Яблоко", 50);
        Product cheese = new DiscountedProduct("Сыр", 200, 25);
        Product coffee = new FixPriceProduct("Кофе");
        Product book = new DiscountedProduct("Книга", 500, 10);
        Product tea = new SimpleProduct("Чай", 80);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(cheese);
        basket.addProduct(coffee);
        basket.addProduct(book);
        basket.addProduct(tea);

        basket.addProduct(new SimpleProduct("Груша", 60));

        basket.printBasket();

        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Есть ли Кофе? " + basket.containsProduct("Кофе"));
        System.out.println("Есть ли Молоко? " + basket.containsProduct("Молоко"));

        basket.clear();

        basket.printBasket();
    }
}
