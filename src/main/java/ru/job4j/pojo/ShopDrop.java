package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (index < 0 && index >= products.length) {
            System.out.println("В списке продуктов нет такого индекса");
            return  products;
        }
        products[index] = null;
        for (int i = index; i < products.length - 1; i++) {
            if (products[i] == null) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        return products;
    }
}
