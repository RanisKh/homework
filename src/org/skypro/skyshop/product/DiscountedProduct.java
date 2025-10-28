package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private double basePrice;
    private double discountInPercentages;

    public DiscountedProduct(String product, double basePrice, double discountInPercentages) {
        super(product);
        validateBasePrice(basePrice);
        validateDiscountPercentages();
        this.basePrice = basePrice;
        this.discountInPercentages = discountInPercentages;
    }

    private void validateBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0. Передано: " + basePrice);
        }
    }

    private void validateDiscountPercentages() {
        if (discountInPercentages < 0 || discountInPercentages > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно. Передано: " + discountInPercentages);
        }
    }

    public double getDiscountInPercentages() {
        return basePrice - (basePrice / 100 * discountInPercentages);
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Скидочный продут: " + name + ", стоимость=" + basePrice +
                "скидка" + discountInPercentages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return Double.compare(basePrice, that.basePrice) == 0 && Double.compare(discountInPercentages, that.discountInPercentages) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, discountInPercentages);
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}