package ps.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11047_동전 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] units = new int[N];
        for(int i = 0; i < N; i++) {
            units[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        for(int i = 0; i < units.length; i++) {
            result += K / units[units.length - i - 1];
            K %= units[units.length - i - 1];
        }

        System.out.println(result);
    }

}
