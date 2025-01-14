package com.example.kiosk2;

import java.util.List;

public class MenuBoard {
    List<MenuItem> menuItemList;

    public boolean addItem(MenuItem item){
        menuItemList.add(item);
        return true;
    }

    public List<MenuItem> getItemList(){
        return menuItemList;
    }
}
