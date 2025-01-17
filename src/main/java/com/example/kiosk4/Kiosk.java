package com.example.kiosk4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    private final Scanner sc = new Scanner(System.in);

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        while (true) {
            // 메뉴 헤더
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료 | 종료");

            try {
                System.out.print("메뉴를 선택하세요: ");
                int index = sc.nextInt();
                sc.nextLine();

                if (index == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                try {
                    Menu selectedMenu = menus.get(index - 1);

                    while (true) {
                        selectedMenu.displayMenuItems();
                        System.out.println("0. 뒤로가기 | 뒤로가기");
                        System.out.print("메뉴 아이템을 선택하세요: ");

                        try {
                            int itemIndex = sc.nextInt();
                            sc.nextLine();

                            if (itemIndex == 0) {
                                break; // 서브 메뉴 종료
                            }

                            try {
                                MenuItem selectedItem = selectedMenu.getMenuItems().get(itemIndex - 1);
                                System.out.println("선택한 메뉴: " + selectedItem);
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                            sc.nextLine(); // 버퍼 클리어
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine(); // 버퍼 클리어
            }
        }
        sc.close();
    }
}
