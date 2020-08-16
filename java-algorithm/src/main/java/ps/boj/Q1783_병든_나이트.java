package ps.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1783_병든_나이트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        System.out.println(getGreatestCount(N, M));
    }

    public static int getGreatestCount(int N, int M) {
        if(N == 1) {
            return 1;
        }
        if(N == 2) {
            return Math.min(4, (M + 1) / 2);
        }
        if(M < 7) {
            return Math.min(4, M);
        }
        return M - 2;
    }

}
