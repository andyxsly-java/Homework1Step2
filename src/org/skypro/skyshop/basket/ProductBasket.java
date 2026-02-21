package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products
                .computeIfAbsent(product.getName(), k -> new ArrayList<>())
                .add(product);
    }

    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice());

        long specialCount = getSpecialCount();
        if (specialCount > 0) {
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removed = products.remove(name);
        return removed == null ? new ArrayList<>() : removed;
    }
}
