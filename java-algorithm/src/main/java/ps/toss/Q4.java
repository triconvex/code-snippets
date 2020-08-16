package ps.toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Q4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringBuilder output = new StringBuilder();
        Stack<String> agencies = new Stack<>();

        for (String s : input.split(" ")) {
            agencies.add(s);

            StringBuilder line = new StringBuilder();

            Set<String> refinedAgencies = new LinkedHashSet<>();
            Stack<String> temp = new Stack<>();
            temp.addAll(agencies);

            while (!temp.isEmpty() && refinedAgencies.size() < 5) {
                refinedAgencies.add(temp.pop());
            }

            for (String a : refinedAgencies) {
                line.append(a).append(" ");
            }
            output.append(line.toString().trim()).append(System.lineSeparator());
        }

        bw.write(output.toString().trim());
        bw.flush();
    }

}
