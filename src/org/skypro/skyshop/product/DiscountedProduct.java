package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    double basePrice;
    double discountInPercentages ;

    public DiscountedProduct(String product, int basePrice, int discountInPercentages) {
        super(product);
        if(basePrice <=0 ){
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0.");
        }
        if (discountInPercentages < 0 && discountInPercentages > 100){
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно.");
        }
        this.basePrice = basePrice;
        this.discountInPercentages = discountInPercentages;
    }

    public double getDiscountInPercentages() {
        return basePrice - (basePrice/ 100 * discountInPercentages);
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    public boolean isSpecial(){
        return true;
    }

    @Override
    public String toString() {
        return "Скидочный продут: "  + name +  ", стоимость=" + basePrice +
                "скидка" + discountInPercentages;
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
