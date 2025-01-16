package com.example.kiosk2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuBoard menuBoard = new MenuBoard();
        Scanner sc = new Scanner(System.in);

        while(true){
            menuBoard.printMenu();

            System.out.print("메뉴를 선택하세요: ");
            int index = sc.nextInt();
            sc.nextLine();

            if(index==0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try { // 선택된 아이템을 출력
                MenuItem selectedItem = menuBoard.getItem(index);
                System.out.println("선택한 메뉴: " + selectedItem);
                break;

            }catch (IndexOutOfBoundsException e){ // 예외 처리
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
