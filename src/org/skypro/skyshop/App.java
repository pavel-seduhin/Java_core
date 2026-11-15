package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        //Создание продуктов
        Product product1 = new SimpleProduct("Кефир", 80);
        Product product2 = new DiscountedProduct("Молоко", 50, (byte) 20);
        Product product3 = new FixPriceProduct("Хлеб");
        Product product4 = new SimpleProduct("Сыр", 150);
        Product product5 = new SimpleProduct("Колбаса", 250);
        Product product6 = new SimpleProduct("Пиво", 120);

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

        //Создание массива элементов для поиска
        SearchEngine itemsArray = new SearchEngine(12);

        //Добавление товаров для поиска в массив
        itemsArray.add(product1);
        itemsArray.add(product2);
        itemsArray.add(product3);
        itemsArray.add(product4);
        itemsArray.add(product5);
        itemsArray.add(product6);

        //Создание статей
        Article article1 = new Article("Кефир", "Светаево, обезжиренный, 900гр.");
        Article article2 = new Article("Молоко", "Простоквашино, отборное, пастеризованное, 1.5л.");
        Article article3 = new Article("Хлеб", "Чёрный, формовой, бездрожжевой, 450гр.");
        Article article4 = new Article("Сыр", "Российский, жирность 45%, 200гр.");
        Article article5 = new Article("Колбаса", "Варёная, Докторская, 380гр.");
        Article article6 = new Article("Пиво", "Тёмное, нефильтрованное, 500гр.");

        //Добавление статей в массив для поиска
        itemsArray.add(article1);
        itemsArray.add(article2);
        itemsArray.add(article3);
        itemsArray.add(article4);
        itemsArray.add(article5);
        itemsArray.add(article6);

        //Поиск товара и статьи
        System.out.println("\nПоиск товара и статьи");
        Searchable[] foundedItems = itemsArray.search("Колбаса");
        for (Searchable foundedItem : foundedItems) {
            if (foundedItem != null) {
                foundedItem.getStringRepresentation();
                System.out.println(foundedItem);
            }
        }

        //Проверка выбрасывания исключений
        System.out.println("\nПроверка выбрасывания исключений");
        Product product7 = new SimpleProduct(null, 140);
        Product product8 = new SimpleProduct("", 140);
        Product product9 = new SimpleProduct(" ", 140);
        Product product10 = new SimpleProduct("Творог", 0);
        Product product11 = new DiscountedProduct("Сок", 0, (byte) 20);
        Product product12 = new DiscountedProduct("Сахар", 79, (byte) 110);
        Product product13 = new DiscountedProduct("Соль", 60, (byte) -5);

        //Демонстрация поиска существующего объекта
        System.out.println("\nДемонстрация поиска существующего объекта");
        try {
            Searchable bestResult = itemsArray.searchBestResult("ЛЕб");
            System.out.println(bestResult);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        //Демонстрация поиска несуществующего объекта
        System.out.println("\nДемонстрация поиска несуществующего объекта");
        try {
            Searchable bestResult = itemsArray.searchBestResult("gw");
            System.out.println(bestResult);
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}