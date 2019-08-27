package oopanddesignpattern.chapter3;

public class Main {

    public static void main(String[] args) {
        Coupon coupon = new Coupon(3000);
        int price = coupon.calculateDiscountedPrice(5000);

        LimitPriceCoupon limitPriceCoupon = new LimitPriceCoupon(5000, 1000);
        int discountAmount = limitPriceCoupon.getDiscountAmount(); //super class에서 확장
        int limitPrice = limitPriceCoupon.getLimitPrice(); // limitPriceCoupon에 정의
    }

}
