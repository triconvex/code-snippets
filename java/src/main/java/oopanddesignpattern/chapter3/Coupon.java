package oopanddesignpattern.chapter3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Coupon {

    private int discountAmount;

    public int calculateDiscountedPrice(int price) {
        if(price < discountAmount) {
            return 0;
        }

        return price - discountAmount;
    }

}