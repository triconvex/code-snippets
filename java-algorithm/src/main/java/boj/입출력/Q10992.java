package boj.입출력;

import java.io.*;

public class Q10992 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfInput = Integer.parseInt(br.readLine());

        for(int i = 1; i < numberOfInput; i++) {
            bw.write(" ");
        }
        bw.write("*\n");

        if(numberOfInput > 1) {
            for(int i = 2; i <= numberOfInput - 1; i++) {
                for(int j = i; j <= numberOfInput - 1; j++) {
                    bw.write(" ");
                }
                bw.write("*");
                for(int j = 1; j <= i * 2 - 3; j++) {
                    bw.write(" ");
                }
                bw.write("*\n");
            }

            for(int i = 1; i <= numberOfInput * 2 - 1; i++) {
                bw.write("*");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int start = n - 1;
        int end = n - 1;

        for(int i = 0; i < n; i++) {
            int num = end + 1;
            for(int j = 0; j < num; j++) {
                if(i == n - 1 || j == start || j == end) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
            start--;
            end++;
        }
        bw.flush();
        bw.close();
    }

    public static void main3(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n + i; j++) {
                if(i == n - 1 || j == n - i + 1 || j == n + i + 1) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

}
