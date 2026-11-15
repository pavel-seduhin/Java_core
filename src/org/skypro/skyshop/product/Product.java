package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        try {
            checkName(productName);
        } catch (IllegalArgumentException e) {
            System.out.println("Отсутствует название продукта");
        }
        this.productName = productName;
    }

    private static void checkName (String productName) throws IllegalArgumentException {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return this.productName + " " + getProductPrice() + "руб.";
    }

    @Override
    public String getName() {
        return getProductName();
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public void getStringRepresentation() {
        System.out.println(getName() + " - " + getType());
    }
}

