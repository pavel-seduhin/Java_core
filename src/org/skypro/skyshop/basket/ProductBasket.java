package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> productBasket = new LinkedList<>();

    public void addProductToBasket(Product product) {
        productBasket.add(product);
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
        int specialProducts = 0;
        if (isBasketEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Product product : productBasket) {
                if (product == null) {
                    break;
                }
                if (product.isSpecial()){
                    specialProducts++;
                }
                System.out.println(product);
            }
            System.out.println("Итого: " + calculateBasketPrice());
            System.out.println("Специальных товаров: " + specialProducts);
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
        productBasket.clear();
    }

    public List<Product> removedProducts = new LinkedList<>();

    public void removeProduct(String name) {
        int removedProductsCount = 0;
        Iterator<Product> iterator = productBasket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
                removedProductsCount++;
            }
        }
        if (removedProductsCount == 0) {
            System.out.println("Такого продукта нет в корзине");
        }
    }

    public void printRemovedProducts(List<Product> removedProducts) {
        if (removedProducts.isEmpty()) {
            System.out.println("Список удалённых продуктов пуст");
        } else {
        for (Product product : removedProducts) { System.out.println(product); }
        }
    }
}

