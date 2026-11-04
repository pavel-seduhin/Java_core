package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return this.productName + " " + getProductPrice();
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

