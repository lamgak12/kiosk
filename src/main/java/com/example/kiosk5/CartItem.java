package com.example.kiosk5;

public class CartItem {
    private final MenuItem menuItem;
    private int quantity;

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }


    public MenuItem getMenuItem() {
        return menuItem;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubTotalPrice() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x %d개 | W %.2f | w %.2f",
                menuItem.getName(), quantity, menuItem.getPrice(), getSubTotalPrice()
                );

    }
}
