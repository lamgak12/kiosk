package com.example.kiosk2;

/**
 * 1. 이름, 가격, 설명이 담겨있는 데이터
 * 2. 이름, 가격, 설명를 각각 불러올 수 있음
 * 3. MenuItem을 호출하면 정보가 출력되어야함
 * */
public class MenuItem {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%-15s | W %-2.1f | %s", this.name, this.price, this.description);
    }
}
