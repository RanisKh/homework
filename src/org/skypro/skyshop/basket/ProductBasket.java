package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            String productName = product.getName();

            productsMap.putIfAbsent(productName, new ArrayList<>());

            productsMap.get(productName).add(product);
        }
    }

    public void removeProduct(Product product) {
        if (product != null) {
            String productName = product.getName();
            List<Product> productWithSameName = productsMap.get(productName);

            if (productWithSameName != null) {
                productWithSameName.remove(product);

                if (productWithSameName.isEmpty()) {
                    productsMap.remove(productName);
                }
            }
        }
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public List<Product> removeAllProductsByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }

        String searchName = name.trim().toLowerCase();
        List<Product> removedProducts = productsMap.remove(searchName);


        return removedProducts != null ? removedProducts : new ArrayList<>();
    }

    public int printProductBasket() {
        int specialCount = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }


    public boolean hasProduct(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return productsMap.containsKey(name.trim());
    }

    public void clearBasket() {
        productsMap.clear();
    }

    public Product[] getProducts() {
        List<Product> allProducts = getAllProductsList();
        return allProducts.toArray(new Product[0]);
    }

    public List<Product> getProductsList() {
        return getAllProductsList();
    }

    private List<Product> getAllProductsList() {
        List<Product> allProducts = new ArrayList<>();

        for (List<Product> productList : productsMap.values()) {
            allProducts.addAll(productList);
        }

        return allProducts;
    }

    public int getProductCount() {
        int count = 0;

        for (List<Product> productList : productsMap.values()) {
            count += productList.size();
        }

        return count;
    }

    public int getUniqueProductCount() {
        return productsMap.size();
    }


    @Override
    public String toString() {
        if (productsMap.isEmpty()) {
            return "Корзина пуста";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Содержимое корзины:\n");

        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            String productName = entry.getKey();
            List<Product> products = entry.getValue();

            for (Product product : products) {
                sb.append("- ").append(productName)
                        .append(": ").append(product.getPrice())
                        .append(" руб.\n");
            }
        }

        sb.append("Общая стоимость: ").append(getTotalPrice()).append(" руб.");
        sb.append("\nУникальных наименований: ").append(getUniqueProductCount());
        sb.append("\nВсего продуктов: ").append(getProductCount());

        return sb.toString();
    }


}