package com.example.kiosk5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk_t {
    private final List<Menu> menus;
    private final Scanner sc = new Scanner(System.in);
    private final Cart cart;
    public Kiosk_t(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
    }

    public void start() {
        while (true) {
            // 메뉴 헤더 출력
            displayList("MAIN", menus);

            int index = getValidInput(menus, "메뉴를 선택하세요: ",true);
            if (index == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch(index){
                case 4:
                    if(!cart.isEmpty()){
                        orderConfirmation();
                    }
                    break;
                case 5:
                    if(!cart.isEmpty()){
                        handleCancelOrder();
                    }
                    break;
                default:
                    handleSubMenu(menus.get(index - 1));
                    break;
            }
        }
        sc.close();
    }

    private void handleSubMenu(Menu selectedMenu) {
        while (true) {
            // 서브 메뉴 출력
            displayList(selectedMenu.getCategoryName().toUpperCase(), selectedMenu.getMenuItems());

            int itemIndex = getValidInput(selectedMenu.getMenuItems(), "메뉴 아이템을 선택하세요: ",true);
            if (itemIndex == 0) {
                break; // 서브 메뉴 종료
            }

            MenuItem selectedItem = selectedMenu.getMenuItems().get(itemIndex - 1);
            System.out.println("선택한 메뉴: " + selectedItem);
            int indexed = getValidInput(List.of(1,2),"위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인 \t\t2.취소\n숫자를 입력하세요: ",false);

            if(indexed==1){
                int quantity = getValidInput(List.of(), "몇개를 주문하시겠습니까?\n숫자를 입력하세요: ",false);
                cart.addCart(selectedItem, quantity);
                break;
            }else if (indexed == 2){
                System.out.println("선택하신 " +selectedItem.getName()+"의 주문이 취소 되었습니다.");
                break;
            }

        }
    }

    private void handleCancelOrder() {
        System.out.println("장바구니에서 취소할 메뉴를 선택하세요.");

        // 장바구니에 있는 아이템을 출력하고, 사용자가 선택할 수 있도록 유도
        cart.printCart();
        int itemIndex = getValidInput(cart.getCartItems(), "취소할 아이템 번호를 입력하세요: ", false); // 취소할 아이템 선택
        int quantity = getValidInput(List.of(), "몇 개를 취소하시겠습니까? 숫자를 입력하세요: ", false); // 취소할 수량 입력

        // 아이템을 장바구니에서 제거
        try {
            cart.removeCartItem(itemIndex, quantity);
        }catch (IndexOutOfBoundsException e){
            System.out.println("취소할 수 없는 수량입니다." + e.getMessage());
        }

        //return;
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
        if(name.equals("MAIN") && !cart.isEmpty()){
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders | 장바구니 확인 후 주문");
            System.out.println("5. Cancel | 진행중인 주문 취소");
        }
    }

    // 유효한 입력을 받는 메서드 (범위 체크 + 예외 처리 통합)
    public <T>int getValidInput(List<T> list, String prompt,boolean allowZero) {
        int maxIndex = list.size(); // 기본적으로 리스트 크기만큼 선택 가능
        if (list == menus && !cart.isEmpty()) {
            maxIndex += 2; // 장바구니 보기(4), 주문하기(5) 추가
        }
        int index = -1;

        while (true) {
            System.out.print(prompt);
            try {
                index = sc.nextInt();
                sc.nextLine();
                if(list.isEmpty()){
                    if(index < 1){
                        throw new IndexOutOfBoundsException("1개 이상의 개수를 입력해주세요.");
                    }
                }else {
                    if ((!allowZero && index == 0) || index < 0 || index > maxIndex) {
                        throw new IndexOutOfBoundsException("선택지에 없는 번호입니다.");
                    }
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
    public void orderConfirmation() {
        System.out.println("\n[ 주문 확인 ]");
        cart.printCart(); // 장바구니 출력
        System.out.println("\n1. 주문      2. 메뉴판");

        int option = getValidInput(List.of(1, 2), "숫자를 입력하세요: ", false);

        if (option == 1) {
            DiscountType.printDiscountType();
            int discountIndex = getValidInput(List.of(1, 2, 3, 4), "할인 유형을 선택하세요: ", false);

            // 할인 유형에 맞는 DiscountType 객체 선택
            DiscountType selectedDiscount = DiscountType.values()[discountIndex - 1];

            // 장바구니 총액 계산
            double totalPrice = cart.calculateTotalPrice();

            // 할인율 적용한 금액 계산
            double discountedPrice = selectedDiscount.applyDiscount(totalPrice);

            System.out.println("최종 결제 금액: W" + discountedPrice + " (" + selectedDiscount + " 할인 적용)");
            cart.clear(); // 주문 후 장바구니 초기화
            System.out.println("주문이 완료되었습니다.\n메뉴판으로 돌아갑니다.");
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }
}
