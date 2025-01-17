package com.example.kiosk5;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int index = 1; //key
    private CartItem cartItem; // 별도의 dto ->value

    private Map<Integer, CartItem> cart;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void addCart(MenuItem menuItem){
        for(CartItem cartItem : cart.values()){
            if(cartItem.getMenuItem().equals(menuItem)){
                cartItem.increaseCount();
                return;
            }
        }

        cart.put(index, new CartItem(menuItem, 1));
        index++;
    }

    public void printCart(){
        if(cart.isEmpty()){
            System.out.println("장바구니가 비었습니다.");
        }
        System.out.println("=== 장바구니 ===");
        for(Map.Entry<Integer, CartItem> entry: cart.entrySet()){
            System.out.println(entry.getKey() + ": "+entry.getValue());
            getTotalPrice();
        }
    }

    public double getTotalPrice(){
        double total = 0.0;
        for(CartItem cartItem : cart.values()){
            total += cartItem.getSubTotalPrice();
        }
        return total;
    }
}
