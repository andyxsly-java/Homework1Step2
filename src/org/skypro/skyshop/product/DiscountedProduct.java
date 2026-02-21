package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class DiscountedProduct extends Product {
    private final int price;
    private final int discount;

    public DiscountedProduct(String name, int price, int discount) {
        super(name);

        if (price <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0: " + price);
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100: " + discount);
        }

        this.price = price;
        this.discount = discount;
    }

    public int getFinalPrice() {
        return price * (100 - discount) / 100;
    }

    @Override
    public int getPrice() {
        return price - (price * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}

