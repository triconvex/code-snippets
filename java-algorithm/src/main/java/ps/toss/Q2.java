package ps.toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Q2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Set<Integer> numbers = new LinkedHashSet<>();

        for (String numberAsString : input.split(" ")) {
            int number = Integer.parseInt(numberAsString);

            if (number < 1 || number > 45) {
                bw.write("false");
                bw.flush();
                return;
            }
            numbers.add(number);
        }

        if (numbers.size() != 6) {
            bw.write("false");
            bw.flush();
            return;
        }

        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        int index = 0;
        for (Integer number : numbers) {
            if (!number.equals(sortedNumbers.get(index))) {
                bw.write("false");
                bw.flush();
                return;
            }
            ++index;
        }

        bw.write("true");
        bw.flush();
    }

}
