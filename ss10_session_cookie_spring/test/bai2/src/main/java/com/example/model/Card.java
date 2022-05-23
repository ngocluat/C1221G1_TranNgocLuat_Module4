package com.example.model;

import java.util.HashMap;
import java.util.Map;

public class Card {
    Map<Product, Integer> productIntegerMap = new HashMap<>();


    public Map<Product, Integer> getProductIntegerMap() {
        return productIntegerMap;
    }

    public void setProductIntegerMap(Map<Product, Integer> productIntegerMap) {
        this.productIntegerMap = productIntegerMap;
    }


    public void addToCard(Product product) {
        if (productIntegerMap.containsKey(product)) {
            Integer total = productIntegerMap.get(product);
            productIntegerMap.put(product, total + 1);
        } else {
            productIntegerMap.put(product, 1);

        }
    }
}
