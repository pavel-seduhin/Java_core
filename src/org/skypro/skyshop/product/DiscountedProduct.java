package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private byte discountInWholePercent;

    public DiscountedProduct(String productName, int basePrice, byte discountInWholePercent) {
        super(productName);
        try {
            checkDiscountProductPriceData(basePrice, discountInWholePercent);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверные данные о цене продукта " + "\""+ productName + "\"");
        }
        this.basePrice = basePrice;
        this.discountInWholePercent = discountInWholePercent;
    }

    private static void checkDiscountProductPriceData(int basePrice, byte discountInWholePercent) throws IllegalArgumentException {
        if (basePrice < 1 || discountInWholePercent < 0 || discountInWholePercent > 100) {
            throw new IllegalArgumentException();
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
