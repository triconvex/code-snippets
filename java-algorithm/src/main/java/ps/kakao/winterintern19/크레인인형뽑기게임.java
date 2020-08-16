package ps.kakao.winterintern19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;
import org.junit.Test;

public class 크레인인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        final int N = board.length;
        List<Queue<Integer>> toys = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> toys.add(new LinkedList<>()));

        for (int[] elements : board) {
            for (int i = 0; i < N; i++) {
                if (elements[i] != 0) {
                    toys.get(i).add(elements[i]);
                }
            }
        }

        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for (Integer i : moves) {
            if (toys.get(i - 1).isEmpty()) {
                continue;
            }
            int pickedToy = toys.get(i - 1).poll();
            if (!bucket.isEmpty() && bucket.peek().equals(pickedToy)) {
                bucket.pop();
                answer += 2;
            } else {
                bucket.add(pickedToy);
            }
        }
        return answer;
    }

    @Test
    public void test() {
        int[][] boards = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(boards, moves));
    }

}
