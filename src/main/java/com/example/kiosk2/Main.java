package com.example.kiosk2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuBoard menuBoard = new MenuBoard();
        menuBoard.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuBoard.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuBoard.addItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuBoard.addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));


        List<MenuItem> menuItemList = menuBoard.getItems();
        String format = "%-15s | W %-2.1f | %s%n";
        for (int i = 0; i < menuItemList.size(); i++) {
            MenuItem menuItem = menuItemList.get(i);
            System.out.printf("%d. " + format, i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
        }

        System.out.println("0. 종료    | 종료");
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴를 선택하세요: ");
        int index = sc.nextInt();
        sc.nextLine();
        if(!(menuBoard.getItem(index) == null)){
            System.out.println(menuBoard.getItem(index));
        }
    }
}
