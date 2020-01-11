package boj.입출력;

import java.io.*;
import java.util.StringTokenizer;

public class Q11441 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfValues = Integer.parseInt(br.readLine());

        int[] amounts = new int[numberOfValues + 1];
        int[] accumulatedAmounts = new int[numberOfValues + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 1; i <= numberOfValues; i++) {
            amounts[i] = Integer.parseInt(stk.nextToken());
            accumulatedAmounts[i] = accumulatedAmounts[i - 1] + amounts[i];
        }

        int numberOfSections = Integer.parseInt(br.readLine());
        while(numberOfSections > 0) {
            numberOfSections--;
            StringTokenizer section = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(section.nextToken());
            int to = Integer.parseInt(section.nextToken());

            long sum = accumulatedAmounts[to] - accumulatedAmounts[from - 1];
            System.out.println(sum);
        }
    }

    public static void main2(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfValues = Integer.parseInt(br.readLine());

        int[] amounts = new int[numberOfValues + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 1; i <= numberOfValues; i++) {
            int amount = Integer.parseInt(stk.nextToken());
            amounts[i] = amounts[i- 1] + amount;
        }

        int numberOfSections = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfSections; i++) {
            StringTokenizer section = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(section.nextToken()) - 1;
            int to = Integer.parseInt(section.nextToken());

            bw.write(String.valueOf(amounts[to] - amounts[from]));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

}