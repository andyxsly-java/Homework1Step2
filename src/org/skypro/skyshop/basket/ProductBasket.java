package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products;
    private int size;

    public ProductBasket() {
        this.products = new Product[5];
        this.size = 0;
    }

    public void addProduct(Product product) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт: корзина заполнена");
            return;
        }
        products[size] = product;
        size++;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (size == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialsCount = 0;

        for (int i = 0; i < size; i++) {
            Product p = products[i];
            System.out.println(p.toString());

            if (p.isSpecial()) {
                specialsCount++;
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialsCount);
    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }
}
