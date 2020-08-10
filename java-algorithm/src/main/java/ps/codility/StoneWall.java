package ps.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.Test;

public class StoneWall {

    public int solution(int[] H) {
        int count = 0;
        Stack<Integer> bottomHeights = new Stack<>();

        for (int height : H) {
            while (!bottomHeights.isEmpty() && bottomHeights.peek() > height) {
                bottomHeights.pop();
            }

            if (bottomHeights.isEmpty() || bottomHeights.peek() < height) {
                bottomHeights.add(height);
                ++count;
            }
        }

        return count;
    }

    @Test
    public void test() {
        int[] H = {8, 8, 5, 7, 8, 6, 7, 4, 8};
        assertThat(solution(H)).isEqualTo(8);
    }

}
