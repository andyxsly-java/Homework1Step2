package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);

        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше 0: " + basePrice);
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть от 0 до 100: " + discount);
        }

        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getFinalPrice() {
        return basePrice * (100 - discount) / 100;
    }
}
