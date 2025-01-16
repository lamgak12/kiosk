package com.example.kiosk5;

public class CartItem {
    private MenuItem menuItem;
    private int count;

    public CartItem(MenuItem menuItem, int count) {
        this.menuItem = menuItem;
        this.count = count;
    }


    public MenuItem getMenuItem() {
        return menuItem;
    }


    public void increaseCount() {
        this.count++;
    }
    public double getSubTotalPrice() {
        return menuItem.getPrice() * count;
    }

    @Override
    public String toString() {
        return String.format("%s x %d개 | w %.1f | w %.1f",
                menuItem.getName(), count, menuItem.getPrice(), getSubTotalPrice()
                );

    }
}
