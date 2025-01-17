package com.example.kiosk5;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String CategoryName;
    private final List<MenuItem> menuItems;

    public Menu(String CategoryName) {
        this.CategoryName = CategoryName;
        this.menuItems = new ArrayList<>();
    }

    // 메뉴 항목 추가
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // 메뉴 항목 리스트 리턴
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    @Override
    public String toString() {
        return CategoryName;
    }
}
