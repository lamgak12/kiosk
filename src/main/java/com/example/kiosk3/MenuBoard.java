package com.example.kiosk3;

import java.util.ArrayList;
import java.util.List;
/**
 * 메뉴 아이템을 List 형식으로 관리하는 클래스
 * */
public class MenuBoard {
    private final List<MenuItem> menuItems;

    public MenuBoard() {
        this.menuItems = new ArrayList<>();
        initializeMenu();
    }

    // MenuBoard 객체가 생성될 때, 같이 실행되는 메서드로 null 가능성 배제시킴
    private void initializeMenu() {
        addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        addItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        addItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    // initializeMenu()메서드로 null 값이 들어올 일이 없으므로 null 검사 생략
    private void addItem(MenuItem item){
        menuItems.add(item);
    }

    // 사용자가 메뉴 번호를 입력하면 해당 메뉴를 반환하는 메서드
    public MenuItem getItem(int index){
        if (index < 1 || index > menuItems.size()) {  // 인덱스가 유효한 범위인지 확인
            throw new IndexOutOfBoundsException("올바른 번호를 선택해주세요.");
        }
        return menuItems.get(index - 1);
    }

    // initializeMenu()로 생성된 MenuItem 객체를 순차적으로 출력하는 메서드
    public void printMenu() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            System.out.println((i+1)+". "+menuItem);
        }
        System.out.println("0. 종료    | 종료");
    }
}
