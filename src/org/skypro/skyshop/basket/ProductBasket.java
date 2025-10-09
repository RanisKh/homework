package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

public class ProductBasket {
    Map<String , LinkedList<Product>> ProductMap;
    int size = 0;
    private List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        LinkedList<Product> products;
        if (!ProductMap.containsKey(product.getName())) {
            products = new LinkedList<>();
            Product.add(product.getName(), products);
        } else {
            ProductMap.get(product.getName());
        }
    }

    public List<Product> deleteNameProduct(String name){
        List<Product> deleteProduct = new LinkedList<>();
        Iterator iterator = ProductMap.get(size).iterator();
        while (iterator.hasNext()){
            Product product = (Product) iterator.next();
            if (product.getName().equalsIgnoreCase(name)){
                deleteProduct.add(product);
                iterator.remove();
            }
        }
        return deleteProduct;
    }

    double totalCost = ProductMap.values()
            .stream()
            .flatMap(List::stream)
            .mapToDouble(Product::getPrice)
            .sum();

    public void printProductBasket(){

        if (size == 0){
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(ProductMap.get(i).toString());
        }

        int specialCount = 0;
        for (int i = 0; i < size; i++) {
            if (products.get(i).isSpecial()){
                specialCount ++;
            }
        }

        System.out.println("Итого: " + totalCost);
        System.out.println("Количество специальных товаров: " + specialCount);


    }



    public boolean hasProduct(String name) {
        for (Product product : products) {
            if (product.getNameProduct().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < ProductMap.size(); i++) {
            ProductMap.put(String.valueOf(i), null);
        }
        for (int i = 0; i < ProductMap.size(); i++) {
            if (ProductMap.get(i) == null){
                size = 0;
            }
        }
    }



    public boolean isEmpty() {
        return products.isEmpty();
    }


    public int getProductCount() {
        return products.size();
    }


    public boolean containsProduct(String productName) {
        for (Product product : products) {
            if (product.getName().contains(productName)) {
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
}