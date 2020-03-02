package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q11399_ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] input = br.readLine().split(" ");
        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            result += numbers.get(i) * (numbers.size() - i);
        }
        System.out.println(result);
    }

}
