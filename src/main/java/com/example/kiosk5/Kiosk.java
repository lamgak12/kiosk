package com.example.kiosk5;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus;
    private final Scanner sc = new Scanner(System.in);
    private final Cart cart;
    public Kiosk(List<Menu> menus) {
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
    // 서브메뉴
    private void handleSubMenu(Menu selectedMenu) {
        while (true) {
            // 서브 메뉴 출력
            displayList(selectedMenu.getCategoryName().toUpperCase(), selectedMenu.getMenuItems());

            int itemIndex = getValidInput(selectedMenu.getMenuItems(), "메뉴 아이템을 선택하세요: ",true);
            if (itemIndex == 0) {
                break; // 서브 메뉴 뒤로가기
            }

            MenuItem selectedItem = selectedMenu.getMenuItems().get(itemIndex - 1);
            System.out.println("선택한 메뉴: " + selectedItem);
            int indexed = getValidInput(List.of(1,2),"위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인 \t\t2.취소\n숫자를 입력하세요: ",false);

            if(indexed==1){
                int quantity = getValidInput(List.of(), "몇개를 주문하시겠습니까?\n숫자를 입력하세요: ",false);
                cart.addCart(selectedItem, quantity);
                break;
            }else if (indexed == 2){
                System.out.println("선택하신 " + selectedItem.getName() + "의 주문이 취소 되었습니다.");
                break;
            }

        }
    }
    // 카테고리 출력 메서드
    private  <T> void displayList(String name, List<T> list) {
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
    private  <T>int getValidInput(List<T> list, String prompt, boolean allowZero) {
        // allowZero는 메인 메뉴, 서브메뉴(ex..햄버거 메뉴) 단계에서 0 입력시 뒤로가게 하기 위해 사용
        int maxIndex = list.size(); // 기본적으로 리스트 크기만큼 선택 가능
        if (list == menus && !cart.isEmpty()) {
            maxIndex += 2; // 장바구니 보기(4), 주문하기(5) 추가
        }
        int index = -1; // 어떤 경우에도 음수가 들어올 수 없다고 판단

        while (true) {
            System.out.print(prompt);
            try {
                index = sc.nextInt(); // 내부에서 번호 혹은 개수 등을 입력받음
                sc.nextLine();
                if(list.isEmpty()){
                    if(index < 1){ // 장바구니 개수를 추가하거나 지울때 사용
                        throw new IndexOutOfBoundsException("1개 이상의 개수를 입력해주세요.");
                    }
                }else { // 메인 메뉴, 서브 메뉴가 아닐때 사용
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

    private void orderConfirmation() {
        System.out.println("\n[ 주문 확인 ]");
        cart.printCart();
        System.out.println("\n1. 주문      2. 메뉴판");

        int option = getValidInput(List.of(1, 2), "숫자를 입력하세요: ", false);

        if (option == 1) {
            DiscountType.printDiscountType(); // 할인유형 프린트
            int discountIndex = getValidInput(List.of(1, 2, 3, 4), "할인 유형을 선택하세요: ", false);

            // 할인 유형에 맞는 DiscountType 객체 선택
            DiscountType selectedDiscount = DiscountType.values()[discountIndex - 1];

            // 장바구니 총액 계산
            double totalPrice = cart.calculateTotalPrice();

            // 할인율 적용한 금액 계산
            double discountedPrice = selectedDiscount.applyDiscount(totalPrice);

            System.out.printf("최종 결제 금액: W %.2f (%s 할인 적용)\n",discountedPrice,selectedDiscount);
            cart.clear(); // 주문 후 장바구니 초기화
            System.out.println("주문이 완료되었습니다.\n메뉴판으로 돌아갑니다.");
        } else {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
    }

    private void handleCancelOrder() {
        System.out.println("장바구니에서 취소할 메뉴를 선택하세요.");
        cart.printCart();

        int itemIndex = getValidInput(cart.getCartItems(), "취소할 아이템 번호를 입력하세요: ", false);

        // 선택한 아이템의 개수
        int availableQuantity = cart.getCartItems().get(itemIndex-1).getQuantity();
        int quantity = getValidInput(List.of(), "몇 개를 취소하시겠습니까? 숫자를 입력하세요: ", false);

        while (quantity > availableQuantity) { // 유효한 수량인지 확인
            System.out.println("장바구니에 있는 개수보다 많습니다. 다시 입력해주세요.");
            quantity = getValidInput(List.of(), "몇 개를 취소하시겠습니까? 숫자를 입력하세요: ", false);
        }

        cart.removeCartItem(itemIndex, quantity);
    }

}
