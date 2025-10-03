package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }


    public void addProduct(Product product) {
        products.add(product);
    }


    public boolean removeProduct(Product product) {
        return products.remove(product);
    }


    public List<Product> getProducts() {
        return new LinkedList<>(products); // возвращаем копию для защиты от изменений
    }


    public void clear() {
        products.clear();
    }


    public boolean isEmpty() {
        return products.isEmpty();
    }


    public int getProductCount() {
        return products.size();
    }


    public boolean containsProduct(String productName) {
        for (Product product : products) {
            // Предполагаем, что у класса Product есть метод getName()
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }


    public boolean removeProductByName(String productName) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(productName)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}