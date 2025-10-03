package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

public abstract class Product implements Searchable {
    String name;

    public Product(String name, double v) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Название продукта не может быть пустой строкой или null.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public boolean isSpecial() {
        return true;
    }
}
