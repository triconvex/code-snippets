package programmers;

import java.util.Arrays;

public class 예산 {

    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);

        if((long) Arrays.stream(budgets).sum() < M) {
            return budgets[budgets.length - 1];
        }

        int left = M / budgets.length;
        int right = budgets[budgets.length - 1];
        int previousMid = 0;

        while(true) {
            int mid = (left + right) / 2;
            long total = getTotal(budgets, mid);

            if(mid == previousMid) {
                return mid;
            }

            if(total > M) {
                right = mid;
            } else {
                left = mid;
            }

            previousMid = mid;
        }
    }

    private long getTotal(int[] budgets, int limit) {
        long total = 0;

        for(int budget : budgets) {
            total += Math.min(budget, limit);
        }

        return total;
    }

}
