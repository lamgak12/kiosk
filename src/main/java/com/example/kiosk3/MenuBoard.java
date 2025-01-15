package com.example.kiosk3;

import java.util.ArrayList;
import java.util.List;

public class MenuBoard {
    private List<MenuItem> menuItems;

    public MenuBoard() {
        this.menuItems = new ArrayList<>();
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

}
