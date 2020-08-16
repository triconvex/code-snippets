package 모던자바인액션;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        // 고전적
        Collections.sort(inventory, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        //자바8
        inventory.sort(Comparator.comparingInt(Apple::getWeight));
    }

    private class Apple {
        private int weight;

        public int getWeight() {
            return weight;
        }
    }

}
