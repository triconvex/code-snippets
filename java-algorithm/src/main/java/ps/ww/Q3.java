package ps.ww;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class Q3 {

    @SuppressWarnings("ConstantConditions")
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        int count = 0;

        Queue<Integer> weights = Arrays.stream(A)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));

        Queue<Integer> destinations = Arrays.stream(B)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));

        while (!weights.isEmpty()) {
            int currentWeight = 0;
            int currentPeople = 0;
            Set<Integer> destinationsOfPassengers = new HashSet<>();

            while (!weights.isEmpty()) {
                if (weights.peek() + currentWeight > Y || currentPeople + 1 > X) {
                    break;
                }
                int weight = weights.poll();
                int destination = destinations.poll();

                currentWeight += weight;
                ++currentPeople;
                destinationsOfPassengers.add(destination);
            }

            count += destinationsOfPassengers.size() + 1;
        }
        return count;
    }

    @Test
    public void test() {
        int[] A = {60, 80, 40, 40};
        int[] B = {1, 2, 1, 2};
        int M = 3;
        int X = 2;
        int Y = 100;

        assertThat((solution(A, B, M, X, Y))).isEqualTo(7);
    }

}
