package com.example.kiosk5;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private CategoryManager categoryManager;
    private Cart cart;
    private Scanner sc;

    public Kiosk() {
        this.categoryManager = new CategoryManager();
        this.cart = new Cart();
        this.sc = new Scanner(System.in);
    }

    public void start() {
        // https://github.com/google/gson/blob/main/UserGuide.md

        setupMenuItem();

        //categoryManager.displayCategories();
        Scanner sc = new Scanner(System.in);

        while(true) {
            List<MenuItemCategory> categories = categoryManager.getItems();//햄버거, 음료수, 디저트라는 데이터가 담김
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < categories.size(); i++) {
                MenuItemCategory itemCategory = categories.get(i);
                System.out.printf("%d. %s\n", i + 1, itemCategory);
            }
            System.out.println("0. 종료    | 종료");

            int categoryChoice = sc.nextInt();
            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } //1번
            // 유저가 카테고리 번호를 선택했으므로 선택한 카테고리 메뉴를 출력하게함
            if (categoryChoice > 0 && categoryChoice <= categories.size()) {
                MenuItemCategory selectedCategory = categories.get(categoryChoice - 1);

                List<MenuItem> items = selectedCategory.getItems();
                String format = "%-15s | W %-2.1f | %s%n";
                for (int i = 0; i < items.size(); i++) {
                    MenuItem menuItem = items.get(i);
                    System.out.printf("%d. " + format, i + 1, menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
                }
                System.out.println("0. 뒤로 가기    | 상위 메뉴로 이동");
                System.out.print("메뉴를 선택하세요: ");
                int menuChoice = sc.nextInt();
                sc.nextLine();
                if (menuChoice == 0) {
                    System.out.println("처음으로 돌아갑니다.");
                    continue;
                }
                if (menuChoice > 0 && menuChoice <= items.size()) {
                    if (!(selectedCategory.getItem(menuChoice) == null)) {
                        System.out.println("=== 선택한 메뉴 ===");
                        System.out.println(selectedCategory.getItem(menuChoice));
//                        if(!isContinue()){
//                            return;
//                        }
                        if(isAdd()){
                            cart.addCart(selectedCategory.getItem(menuChoice));
                            cart.printCart();
                            System.out.println(cart.getTotalPrice());
                        }
                    }
                }
            }
        }
    }

    public boolean isContinue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구매할 상품이 더 있습니까? yes | no");
        String answer = sc.nextLine();
        while (true) {
            if ("yes".equalsIgnoreCase(answer)) {
                return true;
            } else if ("no".equalsIgnoreCase(answer)) {
                return false;
            } else {
                System.out.println("틀린 입력입니다. 다시 입력해주세요. yes | no");
                answer = sc.nextLine();
            }
        }
    }

    public boolean isAdd(){
        Scanner sc = new Scanner(System.in);
        System.out.println("장바구니에 추가하시겠습니까? yes | no");
        String answer = sc.nextLine();
        while (true) {
            if ("yes".equalsIgnoreCase(answer)) {
                return true;
            } else if ("no".equalsIgnoreCase(answer)) {
                return false;
            } else {
                System.out.println("틀린 입력입니다. 다시 입력해주세요. yes | no");
                answer = sc.nextLine();
            }
        }
    }

    private void setupMenuItem(){
        MenuItemCategory burgerCategory = new MenuItemCategory("햄버거");
        categoryManager.addCategory(burgerCategory);
        burgerCategory.addItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerCategory.addItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));

        MenuItemCategory drinkCategory = new MenuItemCategory("음료수");
        categoryManager.addCategory(drinkCategory);
        drinkCategory.addItem(new MenuItem("CocaCola", 1.2, "믿고 마시는 코카콜라"));
        drinkCategory.addItem(new MenuItem("Sprite", 1.2, "청량한 스프라이트"));

        MenuItemCategory dessertCategory = new MenuItemCategory("디저트");
        categoryManager.addCategory(dessertCategory);
        dessertCategory.addItem(new MenuItem("Milk IceCream", 2.0, "상하목장 아이스크림"));
        dessertCategory.addItem(new MenuItem("Choco IceCream", 1.7, "달달한 초코맛"));
    }
}