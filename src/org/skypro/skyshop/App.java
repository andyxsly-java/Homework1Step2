
package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Книга", 500));
        basket.addProduct(new DiscountedProduct("Игрушка", 1000, 500));
        basket.addProduct(new SimpleProduct("Книга", 500));

        System.out.println("\n--- Корзина до удаления ---");
        basket.printBasket();

        System.out.println("\nУдаляем продукт: Игрушка");
        List<Product> removed = basket.removeProductByName("Игрушка");

        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удаленные продукты:");
            removed.forEach(System.out::println);
        }

        System.out.println("\n--- Корзина после удаления ---");
        basket.printBasket();

        System.out.println("\nУдаляем продукт: Телефон");
        removed = basket.removeProductByName("Телефон");

        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("\n--- Корзина после второй попытки удаления ---");
        basket.printBasket();

        // Демонстрация поиска
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct("Настольная игра", 1500));
        searchEngine.add(new SimpleProduct("Игрушка", 200));

        List<Searchable> results = searchEngine.search("игр");

        System.out.println("\nРезультаты поиска: ");
        results.forEach(System.out::println);
    }
}