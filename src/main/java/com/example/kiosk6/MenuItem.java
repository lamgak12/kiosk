package com.example.kiosk5;

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
        return String.format("%-15s | W %-2.1f | %s%n",getName(),getPrice(),getDescription());
        //return "메뉴 이름: " + getName() + "  메뉴 가격: W " + getPrice() + "\t메뉴 설명: " + getDescription();
    }
}
