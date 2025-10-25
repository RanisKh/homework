package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();


        SimpleProduct apple1 = new SimpleProduct("Яблоко", -50.0);
        SimpleProduct banana = new SimpleProduct("Банан", 70.0);
        FixPriceProduct apple2 = new FixPriceProduct("Яблоко");
        DiscountedProduct orange = new DiscountedProduct("Апельсин", 60.0, 120);
        SimpleProduct apple3 = new SimpleProduct("Яблоко", 52.0);

        Article Article1 = new Article("Бананы из юга", "Какой то текст");
        Article test = new Article("Русские яблочки", "Текст другого содержания");

        basket.addProduct(apple1);
        basket.addProduct(banana);
        basket.addProduct(apple2);
        basket.addProduct(orange);
        basket.addProduct(apple3);

        multiCatch();

        s

        System.out.println("Изначальное количество продуктов: " + basket.getProductCount());


    }

    public static void multiCatch() {
        try {
            SimpleProduct apple1 = new SimpleProduct("Яблоко", -50.0);
        } catch (RuntimeException e) {
            System.out.println("Цена указана неверно");
        }
        try {
            DiscountedProduct orange = new DiscountedProduct("Апельсин", 60.0, 120);
        } catch (RuntimeException e) {
            System.out.println("Скидка указана неверно");
        }
    }
}