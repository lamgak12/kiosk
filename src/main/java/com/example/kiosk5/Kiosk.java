package com.example.kiosk5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//public class Kiosk {
//    private final List<Menu> menus;
//    private final Scanner sc = new Scanner(System.in);
//
//    public Kiosk(List<Menu> menus) {
//        this.menus = menus;
//    }
//
//    // 메인 메뉴 출력
//    public void displayAllCategories() {
//        System.out.println("[ MAIN MENU ]");
//        for (int i = 0; i < menus.size(); i++) {
//            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
//        }
//        System.out.println("0. 종료 | 종료");
//    }
//
//    // 유효한 선택 검증
//    private <T> T getValidSelection(List<T> list, int index) {
//        try {
//            return list.get(index - 1); // 인덱스는 1부터 시작하므로 -1
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
//            return null;
//        }
//    }
//
//
//    public void start() {
//        while (true) {
//            displayAllCategories(); // 메인 메뉴 출력
//            try {
//                System.out.print("메뉴를 선택하세요: ");
//                int index = sc.nextInt();
//                sc.nextLine();
//
//                if (index == 0) {
//                    System.out.println("프로그램을 종료합니다.");
//                    break;
//                }
//
//                // 메인 메뉴 선택 및 검증
//                Menu selectedMenu = getValidSelection(menus, index);
//                if (selectedMenu == null) {
//                    continue;
//                }
//
//                // 서브 메뉴 처리
//                while (true) {
//                    selectedMenu.displayMenuItems();
//                    System.out.println("0. 뒤로가기 | 뒤로가기");
//                    System.out.print("메뉴 아이템을 선택하세요: ");
//
//                    try {
//                        int itemIndex = sc.nextInt();
//                        sc.nextLine();
//
//                        if (itemIndex == 0) {
//                            break; // 서브 메뉴 종료
//                        }
//
//                        MenuItem selectedItem = getValidSelection(selectedMenu.getMenuItems(), itemIndex);
//                        if (selectedItem != null) {
//                            System.out.println("선택한 메뉴: " + selectedItem);
//                        }
//
//                    } catch (InputMismatchException e) {
//                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
//                        sc.nextLine(); // 버퍼 클리어
//                    }
//                }
//
//            } catch (InputMismatchException e) {
//                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
//                sc.nextLine(); // 버퍼 클리어
//            }
//        }
//        sc.close();
//    }
//}
/**
 * 겹치는 부분임
 * */

//public class Kiosk {
//    private final List<Menu> menus;
//    private final Scanner sc = new Scanner(System.in);
//
//    public Kiosk(List<Menu> menus) {
//        this.menus = menus;
//    }
//
//    public void start() {
//        while (true) {
//            // 메인 메뉴 출력
//            displayAllCategories("MAIN", menus);
//
//            int index = validateInput(0, menus.size(), "메뉴를 선택하세요: ");
//            if (index == 0) {
//                System.out.println("프로그램을 종료합니다.");
//                break;
//            }
//
//            try {
//                Menu selectedMenu = menus.get(index - 1); // 선택한 메뉴
//
//                while (true) {
//                    // 서브 메뉴 출력
//                    displayAllCategories(selectedMenu.getCategoryName(), selectedMenu.getMenuItems());
//
//                    int itemIndex = validateInput(0, selectedMenu.getMenuItems().size(), "메뉴 아이템을 선택하세요: ");
//                    if (itemIndex == 0) {
//                        break; // 서브 메뉴 종료
//                    }
//
//                    try {
//                        MenuItem selectedItem = selectedMenu.getMenuItems().get(itemIndex - 1);
//                        System.out.println("선택한 메뉴: " + selectedItem);
//                        break;
//                    } catch (IndexOutOfBoundsException e) {
//                        System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
//                    }
//                }
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println("잘못된 번호입니다. 다시 선택해주세요.");
//            }
//        }
//        sc.close();
//    }
//
//    // 카테고리 출력 메서드
//    public <T> void displayAllCategories(String name, List<T> list) {
//        System.out.println("[ " + name + " MENU ]");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println((i + 1) + ". " + list.get(i));
//        }
//        if (name.equals("MAIN")) {
//            System.out.println("0. 종료 | 종료");
//        }else {
//            System.out.println("0. 뒤로가기 | 뒤로가기");
//        }
//    }
//
//    // 유효성 검사를 위한 입력 처리 메서드
//    public int validateInput(int min, int max, String prompt) {
//        int input = -1;
//        while (input < min || input > max) {
//            System.out.print(prompt);
//            try {
//                input = sc.nextInt();
//                sc.nextLine(); // 버퍼 클리어
//                if (input < min || input > max) {
//                    System.out.println("잘못된 입력입니다. 범위 내의 값을 입력해주세요.");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
//                sc.nextLine(); // 버퍼 클리어
//            }
//        }
//        return input;
//    }
//}

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
