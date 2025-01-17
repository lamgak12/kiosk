package com.example.kiosk4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 햄버거 메뉴 생성
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료수 메뉴 생성
        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuItem(new MenuItem("콜라", 2.5, "청량감 있는 탄산 음료"));
        drinkMenu.addMenuItem(new MenuItem("레몬에이드", 3.2, "상큼한 레몬과 설탕이 어우러진 음료"));
        drinkMenu.addMenuItem(new MenuItem("아이스 커피", 3.5, "차가운 커피로 시원하게"));

        // 디저트 메뉴 생성
        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.addMenuItem(new MenuItem("초코 케이크", 4.0, "진한 초콜릿의 케이크"));
        dessertMenu.addMenuItem(new MenuItem("치즈 케이크", 4.5, "부드러운 치즈맛의 케이크"));
        dessertMenu.addMenuItem(new MenuItem("아이스크림", 2.0, "시원한 아이스크림"));

        List<Menu> menus = new ArrayList<>();
        menus.add(burgerMenu);
        menus.add(drinkMenu);
        menus.add(dessertMenu);
        Kiosk kiosk = new Kiosk(menus);

        // Kiosk 내 시작 함수 호출
        kiosk.start();
    }
}