package org.skypro.skyshop.product;


import org.skypro.skyshop.product.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    String name;


    public Product(String product) {
        validateName(name);
        this.name = product;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть null, пустой строкой или состоять только из пробелов");
        }
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public boolean isSpecial() {
        return true;
    }

    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}