package com.example.kiosk1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] burgerNames = {"ShackBurger", "SmokeShack", "Cheeseburger", "Hamburger"};
        double[] burgerPrices = {6.9, 8.9, 6.9, 5.4};
        String[] burgerDescriptions = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "비프패티를 기반으로 야채가 들어간 기본버거"};
        // 각 열의 너비 설정
        String format = "%-15s | W %-2.1f | %s%n";
        // 메뉴 헤더
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < burgerNames.length; i++) {
            System.out.printf("%d. " + format, i + 1, burgerNames[i], burgerPrices[i], burgerDescriptions[i]);
        }
        System.out.println("0. 종료    | 종료");
        String userChoice = sc.nextLine();
        if("0".equals(userChoice)){
            System.out.println("프로그램을 종료합니다.");
        }
    }
}