package ps.programmers;

import org.junit.Test;

public class 조이스틱 {

    public int solution(String name) {
        int count = 0;

        for(int i = 0; i < name.length();) {
            char target = name.charAt(i);
            count += Math.min(target - 'A', 'Z' - target + 1);

            int next = i + 1;

            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            if(next >= name.length()) {
                return count;
            }

            count += Math.min(next - i, i + name.length() - next);
            i = next;
        }

        return count;
    }

    public int solution2(String name) {
        int count = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            char current = name.charAt(i);

            if (current <= 'N') {
                count += current - 'A';
            } else {
                count += 'Z' - current + 1;
            }

            int targetPosition = i + 1;

            while (targetPosition < name.length() && name.charAt(targetPosition) == 'A') {
                targetPosition++;
            }

            int forwardMove = i;
            int reverseMove = name.length() - targetPosition;

            int expectedMove = forwardMove <= reverseMove ? forwardMove * 2 + reverseMove : forwardMove + reverseMove * 2;
            move = Math.min(move, expectedMove);
        }

        count += move;
        return count;
    }

    @Test
    public void test() {
        System.out.println(solution2("ABAAAAAAAAABB"));
    }

}
