package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private final int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        try {
            checkProductPrice(productPrice);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверная цена продукта " + "\""+ productName + "\"");
        }
        this.productPrice = productPrice;
    }

    private static void checkProductPrice (int productPrice) throws IllegalArgumentException {
        if (productPrice < 1) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + "руб.";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
