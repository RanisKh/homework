package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final double FIX_PRICE = 99;

    public FixPriceProduct(String product) {
        super(product, 50.0);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт с фиксированной ценой: " + name + " стоимость " + FIX_PRICE;
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
