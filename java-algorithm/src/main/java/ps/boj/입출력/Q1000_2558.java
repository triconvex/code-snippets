package ps.boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1000_2558 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + b);
    }

    public static void main2(String[] args) throws IOException {
        int a = System.in.read() - '0';
        System.in.read();
        int b = System.in.read() - '0';
        System.out.println(a + b);
    }

    public static void main3(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = br.read() - 48;
        br.read();
        int b = br.read() - 48;
        System.out.println(a + b);
    }

    public static void main4(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        System.out.print(A+B);
    }

}
