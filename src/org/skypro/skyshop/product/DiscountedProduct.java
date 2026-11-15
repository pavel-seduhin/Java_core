package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private byte discountInWholePercent;

    public DiscountedProduct(String productName, int basePrice, byte discountInWholePercent) {
        super(productName);
        try {
            checkDiscountProductPriceData(basePrice, discountInWholePercent);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверные данные о цене продукта " + "\"" + productName + "\" " + e.getMessage());
        }
        this.basePrice = basePrice;
        this.discountInWholePercent = discountInWholePercent;
    }

    private static void checkDiscountProductPriceData(int basePrice, byte discountInWholePercent) throws IllegalArgumentException {
        if (basePrice < 1) {
            throw new IllegalArgumentException(" - Цена продукта не должна быть меньше 1");
        }

        if (discountInWholePercent < 0) {
            throw new IllegalArgumentException(" - Величина скидки не может быть меньше 0");
        }

        if (discountInWholePercent > 100) {
            throw new IllegalArgumentException(" - Величина скидки не может быть больше 100");
        }
    }

    @Override
    public int getProductPrice() {
        return (int)(basePrice * (float)(100 - discountInWholePercent )/ 100.0);
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + "руб." + " (" + discountInWholePercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
