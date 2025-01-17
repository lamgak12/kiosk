package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

class Menu {
    private final String categoryName;
    private final List<MenuItem> menuItems;

    // 생성자 -> 여기서 카테고리를 생성함
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }
    // 카테고리에 메뉴 아이템 추가
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // 메뉴 항목 출력
    public void displayMenuItems() {
        System.out.println("[ "+getCategoryName()+" MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }

    // 메뉴 항목 리스트 반환
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // 카테고리 이름 반환
    public String getCategoryName() {
        return categoryName;
    }
}