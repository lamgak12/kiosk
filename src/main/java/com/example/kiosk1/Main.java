package com.example.kiosk1;

import java.util.Scanner;

/**
 * 1. 메뉴의 이름, 가격, 설명이 있는 데이터를 선언한다.
 * 2. 메뉴 헤더와 각 메뉴 데이터들을 순차적으로 출력한다.
 * 3. 0번을 입력하면 프로그램을 종료한다.
 * 4. 그 외의 선택은 현재 고려사항에서 제외한다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //이름, 가격, 설명을 가지고 있는 배열들을 선언, 각 배열의 길이는 동일해야함
        String[] burgerNames = {"ShackBurger", "SmokeShack", "Cheeseburger", "Hamburger"};
        double[] burgerPrices = {6.9, 8.9, 6.9, 5.4};
        String[] burgerDescriptions = {"토마토, 양상추, 쉑소스가 토핑된 치즈버거", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", "비프패티를 기반으로 야채가 들어간 기본버거"};

        // 메뉴 헤더
        System.out.println("[ SHAKESHACK MENU ]");

        //각 배열의 정보(합쳐서 메뉴)를 출력
        for (int i = 0; i < burgerNames.length; i++) {
            System.out.printf("%d. %-15s | W %-2.1f | %s%n", i + 1, burgerNames[i], burgerPrices[i], burgerDescriptions[i]);
        }
        System.out.println("0. 종료    | 종료");

        String userChoice = sc.nextLine();

        //0을 입력하면 프로그램 종료
        if("0".equals(userChoice)){
            System.out.println("프로그램을 종료합니다.");
        }
    }
}