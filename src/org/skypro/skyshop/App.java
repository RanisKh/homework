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

        // Создаем продукты
        Product apple1 = new Product("Яблоко", 50.0) {
            @Override
            public String searchTerm() {
                return "";
            }

            @Override
            public String getTypeContent() {
                return "";
            }

            @Override
            public String getSearchTerm() {
                return "";
            }

            @Override
            public double getPrice() {
                return 0;
            }
        };
        Product banana = new Product("Банан", 70.0) {
            @Override
            public String searchTerm() {
                return "";
            }

            @Override
            public String getTypeContent() {
                return "";
            }

            @Override
            public String getSearchTerm() {
                return "";
            }

            @Override
            public double getPrice() {
                return 0;
            }
        };
        Product apple2 = new Product("Яблоко", 55.0) {
            @Override
            public String searchTerm() {
                return "";
            }

            @Override
            public String getTypeContent() {
                return "";
            }

            @Override
            public String getSearchTerm() {
                return "";
            }

            @Override
            public double getPrice() {
                return 0;
            }
        };
        Product orange = new Product("Апельсин", 60.0) {
            @Override
            public String searchTerm() {
                return "";
            }

            @Override
            public String getTypeContent() {
                return "";
            }

            @Override
            public String getSearchTerm() {
                return "";
            }

            @Override
            public double getPrice() {
                return 0;
            }
        };
        Product apple3 = new Product("Яблоко", 52.0) {
            @Override
            public String searchTerm() {
                return "";
            }

            @Override
            public String getTypeContent() {
                return "";
            }

            @Override
            public String getSearchTerm() {
                return "";
            }

            @Override
            public double getPrice() {
                return 0;
            }
        };

        // Добавляем продукты в корзину
        basket.addProduct(apple1);
        basket.addProduct(banana);
        basket.addProduct(apple2);
        basket.addProduct(orange);
        basket.addProduct(apple3);

        System.out.println("Изначальное количество продуктов: " + basket.getProductCount());

        // Демонстрация нового метода - удаление всех яблок
        boolean removedApples = basket.removeProductByName("Яблоко");
        System.out.println("Удалено яблок: " + removedApples);
        System.out.println("Осталось продуктов: " + basket.getProductCount());

        // Попытка удалить несуществующий продукт
        boolean removedGrapes = basket.removeProductByName("Виноград");
        System.out.println("Удалено винограда: " + removedGrapes);
        System.out.println("Корзина пуста: " + basket.isEmpty());

        // Показываем удаленные яблоки
        System.out.println("Удаленные яблоки:");
        for (Product apple : removedApples) {
            System.out.println(" - " + apple.getName() + " по цене " + apple.getPrice());
        }

    }
}