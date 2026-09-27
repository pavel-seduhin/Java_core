package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] productBasket = new Product[5];
    int productCounter = 0;

    public void addProductToBasket(Product product) {
        if (productCounter >= productBasket.length) {
            System.out.println("Невозможно добавить продукт");
        } else if (productBasket[productCounter] == null) {
            productBasket[productCounter] = product;
        }
        productCounter++;
    }

    public int calculateBasketPrice() {
        int sum = 0;
        for (Product product : productBasket) {
            if (product == null) {
                break;
            }
            sum = sum + product.getProductPrice();
        }
        return sum;
    }

    private boolean isBasketEmpty() {
        for (Product product : productBasket) {
            if (product == null) {
                return true;
            }
        }
        return false;
    }

    public void printBasketContents() {
        if (isBasketEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : productBasket) {
                if (product == null) {
                    break;
                }
                System.out.println(product.getProductName() + ": " + product.getProductPrice());
            }
            System.out.println("Итого: " + calculateBasketPrice());
        }
    }

    public boolean searchProductInBasket(String itemName) {
        if (isBasketEmpty()) {
            return false;
        } else {
            for (Product product : productBasket) {
                if (product == null) {
                    return false;
                }
                if (itemName.equals(product.getProductName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void makeBasketEmpty() {
        Arrays.fill(productBasket, null);
    }
}

