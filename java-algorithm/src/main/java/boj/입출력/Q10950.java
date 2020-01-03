package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10950 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInput = Integer.parseInt(br.readLine());

        for(int i = 0; i < numberOfInput; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());
            System.out.println(sum);
        }
    }

}
