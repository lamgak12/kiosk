package com.example.kiosk5;

import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    private List<MenuItemCategory> itemCategories;

    public CategoryManager() {
        this.itemCategories = new ArrayList<>();
    }

    public void addCategory(MenuItemCategory category){
        itemCategories.add(category);
    }

    public List<MenuItemCategory> getItems(){
        if(itemCategories.isEmpty()){
            System.out.println("메뉴가 없습니다.");
            return null;
        }
        return itemCategories;
    }

    public void displayCategories() {
        if(itemCategories.isEmpty()){
            System.out.println("메뉴가 없습니다.");
            return;
        }
        for (MenuItemCategory category : itemCategories) {
            System.out.println("=== "+category.getCategoryName() + " ===");
            for (MenuItem item : category.getItems()) {
                System.out.printf("%-15s | W %-2.1f | %s%n",item.getName(),item.getPrice(),item.getDescription());
            }
        }
    }


}
