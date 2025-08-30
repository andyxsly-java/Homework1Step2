package org.skypro.skyshop;

public class App {
    public static void main(String[] args) {

        Product apple = new Product("Яблоко", 65);
        Product bread = new Product("Хлеб", 45);
        Product juice = new Product("Сок", 137);
        Product milk = new Product("Молоко", 120);
        Product orange = new Product("Апельсин", 110);
        Product cheese = new Product("Сыр", 680);
        Product coffee = new Product("Кофе", 370);
        Product chocolate = new Product("Шоколад", 90);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(juice);
        basket.addProduct(milk);
        basket.addProduct(orange);
        basket.addProduct(cheese);
        basket.addProduct(coffee);
        basket.addProduct(chocolate);

        basket.printBasket();

        System.out.println("Общая стоимость: " + basket.getTotalPrice());

        System.out.println("Есть ли Апельсин? " + basket.containsProduct("Апельсин"));

        System.out.println("Есть ли Хлеб? " + basket.containsProduct("Хлеб"));

        basket.clear();

        basket.printBasket();

        System.out.println("Общая стоимость после очищения корзины: " + basket.getTotalPrice());

        System.out.println("Есть ли Шоколад после очищения корзины? " + basket.containsProduct("Шоколад"));
    }
}
