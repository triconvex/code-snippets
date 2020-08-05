package ps.ww;

import java.util.stream.IntStream;
import org.junit.Test;

public class Q4 {

    int origin(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }

    int changed(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }

        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2 + 1;
//            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] A = {1, 3, 4, 5, 7, 10, 15, 19};
        IntStream.range(0, 20).forEach(i -> System.out.println(changed(A, i)));
    }

}
