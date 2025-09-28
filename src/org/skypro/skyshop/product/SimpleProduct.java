package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    double price;


    public SimpleProduct(String product, int price) {
        super(product);
        if (price <= 0){
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0.");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public boolean isSpecial(){
        return false;
    }

    @Override
    public String toString() {
        return "Продукт: "  + name + "стоимость " + price;
    }

    @Override
    public String searchTerm() {
        return "";
    }

    @Override
    public String getTypeContent() {
        return "";
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}
