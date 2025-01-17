package com.example.kiosk5;

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
            // 메뉴 헤더 출력
            displayList("MAIN", menus);

            int index = getValidInput(menus, "메뉴를 선택하세요: ");
            if (index == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            Menu selectedMenu = menus.get(index - 1); // 선택한 메뉴

            while (true) {
                // 서브 메뉴 출력
                displayList(selectedMenu.getCategoryName().toUpperCase(), selectedMenu.getMenuItems());

                int itemIndex = getValidInput(selectedMenu.getMenuItems(), "메뉴 아이템을 선택하세요: ");
                if (itemIndex == 0) {
                    break; // 서브 메뉴 종료
                }

                MenuItem selectedItem = selectedMenu.getMenuItems().get(itemIndex - 1);
                System.out.println("선택한 메뉴: " + selectedItem);
                break; // 메뉴 선택 후 종료
            }
        }
        sc.close();
    }

    // 카테고리 출력 메서드
    public <T> void displayList(String name, List<T> list) {
        System.out.println("[ " + name + " MENU ]");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
        if (name.equals("MAIN")) {
            System.out.println("0. 종료 | 종료");
        }else {
            System.out.println("0. 뒤로가기 | 뒤로가기");
        }
    }

    // 유효한 입력을 받는 메서드 (범위 체크 + 예외 처리 통합)
    public <T>int getValidInput(List<T> list, String prompt) {
        int index = -1;

        while (true) {
            System.out.print(prompt);
            try {
                index = sc.nextInt();
                sc.nextLine();
                if (index < 0 || index > list.size()) {
                    throw new IndexOutOfBoundsException("메뉴판에 없는 번호입니다.");
                }
                break; // 유효한 입력
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine();
            } catch (IndexOutOfBoundsException e) {
                // 범위가 벗어난 경우 예외 처리
                System.out.println(e.getMessage());
            }
        }
        return index;
    }
}
