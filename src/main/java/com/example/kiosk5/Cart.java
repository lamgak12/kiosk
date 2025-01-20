package com.example.kiosk5;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems; // CartItem 목록

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addCart(MenuItem menuItem, int quantity) {
        // 동일한 MenuItem이 이미 있는지 확인
        for (CartItem cartItem : cartItems) {
            if (cartItem.getMenuItem().equals(menuItem)) {
                cartItem.setQuantity(cartItem.getQuantity()+quantity); // 이미 있으면 수량 증가
                return;
            }
        }
        // 없으면 새로운 CartItem 추가
        cartItems.add(new CartItem(menuItem, quantity));
        System.out.println(menuItem.getName()+"이(가) " + quantity + "개 장바구니에 추가되었습니다.");
    }

    public void removeCartItem(int index, int quantity) {

        CartItem cartItem = cartItems.get(index - 1);

        if (cartItem.getQuantity() <= quantity) {
            cartItems.remove(cartItem); // 수량이 삭제하려는 수량 이하이면 아이템 삭제
            System.out.println(cartItem.getMenuItem().getName() + "이(가) 장바구니에서 삭제되었습니다.");
        } else {
            cartItem.setQuantity(cartItem.getQuantity()-quantity); // 수량만큼 감소
            System.out.println(cartItem.getMenuItem().getName() + "의 수량이 " + quantity + "개만큼 감소되었습니다.");
        }
    }

    public void printCart() {
        if (cartItems.isEmpty()) {
            System.out.println("장바구니가 비었습니다.");
            return;
        }

        System.out.println("[ Orders ]");
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            System.out.printf("%d. %s%n", i + 1, cartItem);
        }
        System.out.println("\n[ Total ]");
        System.out.printf("W %.1f%n", getTotalPrice());
    }

    private double getTotalPrice() { // 제품 단가 * 개수 계산
        double total = 0.0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getSubTotalPrice();
        }
        return total;
    }

    // 장바구니 총액 계산
    public double calculateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getMenuItem().getPrice() * item.getQuantity();
        }
        return total;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clear() {
        cartItems.clear();
    }

}
