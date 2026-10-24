package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private static final int PRODUCT_FIXED_PRICE = 45;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getProductPrice() {
        return PRODUCT_FIXED_PRICE;
    }

    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + PRODUCT_FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
