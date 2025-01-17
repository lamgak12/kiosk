package com.example.kiosk5;

import java.util.ArrayList;
import java.util.List;

public class MenuItemCategory {
    private final String categoryName;
    private List<MenuItem> menuItems;

    public MenuItemCategory(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void addItem(MenuItem item){
        menuItems.add(item);
    }

    public List<MenuItem> getItems(){
        if(menuItems.isEmpty()){
            System.out.println("메뉴가 없습니다.");
            return null;
        }
        return menuItems;
    }

    public MenuItem getItem(int index){
        if(menuItems.isEmpty()){
            System.out.println("메뉴가 없습니다.");
            return null;
        }
        if(index == 0){
            System.out.println("시스템을 종료합니다.");
            return null;
        }
        if (index < 1 || index > menuItems.size()) {  // 인덱스가 유효한 범위인지 확인
            System.out.println("잘못된 인덱스입니다.");
            return null;
        }
        return menuItems.get(index - 1);
    }
    @Override
    public String toString() {
        return categoryName; // 카테고리 이름만 반환
    }
}
