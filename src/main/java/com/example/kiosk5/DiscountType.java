package com.example.kiosk5;

public enum DiscountType {
    PATRIOT(1,"국가유공자",0.10),
    SOLDIER(2,"군인",0.05),
    STUDENT(3,"학생",0.03),
    NORMAL(4,"일반인",0.00);

    private final int index;
    private final String discountTypeName;
    private final double rate; // 타입 바꿔도 됨

    DiscountType(int index, String discountTypeName, double rate) {
        this.index = index;
        this.discountTypeName = discountTypeName;
        this.rate = rate;
    }

    // 할인율을 적용한 금액을 계산하는 메서드
    public double applyDiscount(double totalPrice) {
        return totalPrice * (1 - rate);
    }

    @Override
    public String toString() {
        return discountTypeName + " (" + (rate * 100) + "%)";
    }

    public static void printDiscountType() {
        for (DiscountType type : DiscountType.values()) {
            System.out.println(type.index + ". " + type.discountTypeName + " : " + (type.rate * 100) + "%");
        }
    }
}
