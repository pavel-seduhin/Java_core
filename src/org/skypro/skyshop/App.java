package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        //Создание продуктов
        Product product1 = new Product("Кефир", 80);
        Product product2 = new Product("Молоко", 50);
        Product product3 = new Product("Хлеб", 45);
        Product product4 = new Product("Сыр", 150);
        Product product5 = new Product("Колбаса", 250);
        Product product6 = new Product("Пиво", 120);

        //Создание корзины
        ProductBasket productBasket = new ProductBasket();

        //Добавление продуктов в корзину
        productBasket.addProductToBasket(product1);
        productBasket.addProductToBasket(product2);
        productBasket.addProductToBasket(product3);
        productBasket.addProductToBasket(product4);
        productBasket.addProductToBasket(product5);

        //Добавление продукта в заполненную корзину
        System.out.println("\nДобавление продукта в заполненную корзину:");
        productBasket.addProductToBasket(product6);

        //Печать содержимого корзины
        System.out.println("\nПечать содержимого корзины:");
        productBasket.printBasketContents();

        //Поиск товара, который есть в корзине
        System.out.println("\nПоиск товара, который есть в корзине:");
        System.out.println(productBasket.searchProductInBasket("Хлеб"));

        //Поиск товара, которого нет в корзине
        System.out.println("\nПоиск товара, которого нет в корзине:");
        System.out.println(productBasket.searchProductInBasket("Пиво"));

        //Очистка корзины
        productBasket.makeBasketEmpty();

        //Печать содержимого пустой корзины
        System.out.println("\nПечать содержимого пустой корзины:");
        productBasket.printBasketContents();

        //Получение стоимости пустой корзины
        System.out.println("\nПолучение стоимости пустой корзины:");
        System.out.println("Итого: " + productBasket.calculateBasketPrice());

        //Поиск товара по имени в пустой корзине
        System.out.println("\nПоиск товара по имени в пустой корзине:");
        System.out.println(productBasket.searchProductInBasket("Хлеб"));

    }
}