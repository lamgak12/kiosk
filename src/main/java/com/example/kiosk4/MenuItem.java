package com.example.kiosk4;

public class MenuItem {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%-15s | W %-2.1f | %s", this.name, this.price, this.description);
    }
}
