package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        SearchEngine engine = new SearchEngine(20);

        engine.add(new SimpleProduct("Milk", 100));
        engine.add(new SimpleProduct("Bread", 50));
        engine.add(new DiscountedProduct("Coffee", 300,20));

        engine.add(new Article("Как выбрать молоко", "Полезные советы по выбору молока"));
        engine.add(new Article("Готовим дома", "10 рецептов выпечки"));

        System.out.println(Arrays.toString(engine.search("мол")));
        System.out.println(Arrays.toString(engine.search("коф")));
        System.out.println(Arrays.toString(engine.search("рецепт")));
    }
}
