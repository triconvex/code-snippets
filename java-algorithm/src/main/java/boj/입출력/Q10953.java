package boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10953 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInput = Integer.parseInt(br.readLine());

        for(int i = 0; i < numberOfInput; i++) {
            String input = br.readLine();
            System.out.println(input.charAt(0) + input.charAt(2) - 0x60);
        }
    }

}
