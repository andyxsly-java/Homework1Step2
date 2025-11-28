package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.exception.BestResultNotFound;


public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine(10);

        try {
            engine.add(new SimpleProduct("Milk", 100));
            engine.add(new SimpleProduct("Bread", 50));
            engine.add(new DiscountedProduct("Coffee Coffee", 300, 20));

            // демонстрация ошибочных данных
            engine.add(new SimpleProduct("   ", 10));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка продукта: " + e.getMessage());
        }

        try {
            System.out.println("Лучший результат для 'Coffee': " + engine.bestResult("Coffee"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Лучший результат для 'Tea': " + engine.bestResult("Tea"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}