package ps.programmers;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class 가장큰정사각형찾기 {

    public int solution(int[][] board) {
        int answer = 0;

        if(Stream.of(board).flatMapToInt(Arrays::stream).filter(i -> i != 0).count() == 0) {
            return 0;
        }

        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[i].length; j++) {
                if(board[i][j] > 0) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j - 1], board[i][j - 1]), board[i - 1][j]) + 1;

                    if(board[i][j] > answer) {
                        answer = board[i][j];
                    }
                }
            }
        }

        return Math.max(1, answer * answer);
    }

    @Test
    public void test() {
        int[][] board = {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};
        System.out.println(solution(board));
    }

}
