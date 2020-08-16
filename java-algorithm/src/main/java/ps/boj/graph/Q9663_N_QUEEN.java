package ps.boj.graph;

import java.util.Scanner;

public class Q9663_N_QUEEN {

    private static int input;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        for(int i = 0; i < input; i++) {
            int[] columns = new int[input];
            columns[0] = i;
            dfs(columns, 0);
        }
        System.out.println(count);
    }

    private static void dfs(int[] columns, int row) {
        if(row == input - 1) {
            count++;
        } else {
            for(int j = 0; j < input; j++) {
                columns[row + 1] = j;
                if(isValid(columns, row + 1)) {
                    dfs(columns, row + 1);
                }
            }
        }
    }

    private static boolean isValid(int[] columns, int targetRow) {
        for(int i = 0; i < targetRow; i++) {
            if(columns[i] == columns[targetRow]) {
                return false;
            }
            if(Math.abs(i - targetRow) == Math.abs(columns[i] - columns[targetRow])) {
                return false;
            }
        }
        return true;
    }

}
