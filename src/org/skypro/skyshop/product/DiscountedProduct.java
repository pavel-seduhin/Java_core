package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private byte discountInWholePercent;

    public DiscountedProduct(String productName, int basePrice, byte discountInWholePercent) {
        super(productName);
        this.basePrice = basePrice;
        this.discountInWholePercent = discountInWholePercent;
    }

    @Override
    public int getProductPrice() {
        return (int)(basePrice * (float)(discountInWholePercent / 100.0));
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + " (" + discountInWholePercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
