package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(x -> x.standard() - x.actual() <= 3)
                .filter(x -> x.standard() - x.actual() >= 0)
                .map(x -> new Label(x.name(), x.price() / 2).toString())
                .collect(Collectors.toList());
    }
}
