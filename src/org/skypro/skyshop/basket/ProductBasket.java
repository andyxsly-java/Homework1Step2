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

    public List<Product> removeProductByName(String name) {
        List<Product> removed = products.remove(name);
        return removed == null ? new ArrayList<>() : removed;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product);
            }
        }
    }
}
