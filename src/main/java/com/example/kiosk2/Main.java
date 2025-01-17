package com.example.kiosk2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        while(true){
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.printf("%d. "+menuItems.get(i)+"\n",(i+1));
            }
            try { // 입력된 숫자에 따른 처리
                System.out.print("메뉴를 선택하세요: ");
                int index = sc.nextInt(); // 숫자를 입력 받기
                sc.nextLine();

                if (index == 0) { // 프로그램을 종료
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
                // 선택한 메뉴 : 이름, 가격, 설명
                System.out.println("선택한 메뉴: " + menuItems.get(index - 1));

            }catch (InputMismatchException e){
                // menuItems의 인덱스를 입력할때 숫자로 입력했는지 확인
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();
            }catch (IndexOutOfBoundsException e){ // menuItems의 범위를 벗어나는지 확인
                System.out.println("메뉴판에 없는 번호입니다.");
            }


        }
        sc.close();
    }
}
