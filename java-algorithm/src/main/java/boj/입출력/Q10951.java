package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(line);
            int sum = Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());
            System.out.println(sum);
        }
    }

    public static void main2(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            System.out.println(input.charAt(0) + input.charAt(2) - 0x60);
        }
    }

    public static void main3(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            String[] num = line.split(" ");
            sb.append(Integer.parseInt(num[0])).append(Integer.parseInt(num[1])).append("\n");
        }
        System.out.println(sb);
    }

}
