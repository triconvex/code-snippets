package ps.toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Q3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Map<Integer, Integer> container = new HashMap<>();

        StringBuilder output = new StringBuilder();

        for (String s : input.split(" ")) {
            int key = Integer.parseInt(s);

            if (container.containsKey(key)) {
                output.append(container.get(key) + " ");
            } else {
                int value = compute(key);
                container.put(key, value);
                output.append(value + " ");
            }
        }

        bw.write(output.toString().trim());
        bw.flush();
    }

    private static int compute(int n) {
        return 0;
    }

}
