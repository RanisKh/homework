package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Article[] articles = {
                new Article("Треска", "Треска, дальневосточная выращенная с ошибками "),
                new Article("Баранина", "Выращенная на бескрайних полях Сахары"),
                new Article("Banana", "Bananas from Arctic")
        };
        SearchEngine collection = new SearchEngine(articles);
        Article[] foundArticles = collection.searchByKeyword("выращенная");
        SearchEngine searchEngine = new SearchEngine();



        // Выводим найденные статьи
        for (Article article : foundArticles) {
            System.out.println("Название: " + article.getTitle());
            System.out.println("Текст: " + article.getText());
            System.out.println("---");
        }

        ProductBasket productBasket = new ProductBasket(5);


        Product butter = new FixPriceProduct("Banana");
        Product fish = new FixPriceProduct("Треска");
        Product meat = new DiscountedProduct("Баранина", 700, 30 );
        Product rise = new SimpleProduct("Рис", 100);
        Product bread = new SimpleProduct("Хлеб", 55);
        Product meat2 = new DiscountedProduct("Говядина", 500, 10);

        productBasket.addProduct(butter);
        productBasket.addProduct(fish);
        productBasket.addProduct(meat2);
        productBasket.addProduct(rise);
        productBasket.addProduct(bread);
        productBasket.addProduct(meat);

        System.out.println("Корзина: ");
        productBasket.printProductBasket();

        Product[] Product = new Product[0];
        System.out.println("Есть ли рыба в корзине " + productBasket.hasProduct(Product, "Рыба"));
        System.out.println("Есть ли баранина в корзине " + productBasket.hasProduct(Product, "Баранина"));

        productBasket.clearBasket();
        productBasket.printProductBasket();



    }
}