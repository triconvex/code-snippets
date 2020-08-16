package ps.toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder output = new StringBuilder("0; ");
        List<Integer> nextContainer = new ArrayList<>();

        int startingPointer = Integer.parseInt(input.split(";")[0]);
        int[] container = Arrays.stream(input.split(";")[1].trim().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        while (true) {
            int division;
            int target;

            if (startingPointer % 2 == 0) {
                division = container[startingPointer - 1];
                target = container[startingPointer];
            } else {
                division = container[startingPointer];
                target = container[startingPointer + 1];
            }

            nextContainer.add(division);

            if (division == 0) {
                startingPointer = target;
                nextContainer.add(nextContainer.size());
            } else {
                nextContainer.add(target);
                break;
            }
        }

        for (int i = 0; i < container.length - nextContainer.size(); i++) {
            nextContainer.add(0);
        }

        for (Integer i : nextContainer) {
            output.append(i).append(" ");
        }

        bw.write(output.toString().trim());
        bw.flush();
    }

}
