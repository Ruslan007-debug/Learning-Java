package org.example;

import org.example.model.Cart;
import org.example.model.Category;
import org.example.model.Order;
import org.example.model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics =
                new Category(1, "Електроніка");

        Category smartphones =
                new Category(2, "Смартфони");

        Category accessories =
                new Category(3, "Аксесуари");


        Product product1 = new Product(
                1,
                "Ноутбук",
                19999.99,
                "Ноутбук для роботи та ігор",
                electronics
        );

        Product product2 = new Product(
                2,
                "Смартфон",
                12999.50,
                "Смартфон з великим екраном",
                smartphones
        );

        Product product3 = new Product(
                3,
                "Навушники",
                2499.00,
                "Бездротові навушники",
                accessories
        );


        List<Product> products =
                List.of(
                        product1,
                        product2,
                        product3
                );


        Cart cart = new Cart();


        while (true) {

            System.out.println();
            System.out.println("1 - Переглянути товари");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Видалити товар");
            System.out.println("5 - Оформити замовлення");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();


            switch (choice) {

                case 1:

                    for (Product product : products) {
                        System.out.println(product);
                    }

                    break;


                case 2:

                    System.out.println(
                            "Введіть ID товару:"
                    );

                    int id = scanner.nextInt();

                    Product productToAdd =
                            products.stream()
                                    .filter(
                                            p -> p.getId() == id
                                    )
                                    .findFirst()
                                    .orElse(null);

                    if (productToAdd != null) {

                        cart.addProduct(productToAdd);

                        System.out.println(
                                "Товар додано"
                        );

                    } else {

                        System.out.println(
                                "Товар не знайдено"
                        );
                    }

                    break;


                case 3:

                    System.out.println(cart);

                    break;


                case 4:

                    System.out.println(
                            "Введіть ID товару:"
                    );

                    int removeId =
                            scanner.nextInt();

                    Product productToRemove =
                            cart.getProducts()
                                    .stream()
                                    .filter(
                                            p -> p.getId()
                                                    == removeId
                                    )
                                    .findFirst()
                                    .orElse(null);


                    if (productToRemove != null) {

                        cart.removeProduct(
                                productToRemove
                        );

                        System.out.println(
                                "Товар видалено"
                        );

                    } else {

                        System.out.println(
                                "Товар у кошику не знайдено"
                        );
                    }

                    break;


                case 5:

                    if (cart.getProducts().isEmpty()) {

                        System.out.println(
                                "Кошик порожній"
                        );

                    } else {

                        Order order =
                                new Order(cart);

                        System.out.println(
                                "Замовлення оформлено:"
                        );

                        System.out.println(order);

                        cart.clear();
                    }

                    break;


                case 0:

                    scanner.close();

                    return;


                default:

                    System.out.println(
                            "Невідома команда"
                    );
            }
        }
    }
}