package oopanddesignpattern.chapter3;

import lombok.Getter;

@Getter
public class LimitPriceCoupon extends Coupon {

    private int limitPrice;

    public LimitPriceCoupon(int limitPrice, int discountAmount) {
        super(discountAmount);
        this.limitPrice = limitPrice;
    }

    @Override
    public int calculateDiscountedPrice(int price) {
        if(price < limitPrice) {
            return price;
        }

        return super.calculateDiscountedPrice(price);
    }

}
