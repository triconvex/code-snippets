package ps.toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q5 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] kimSchedules = br.readLine().split(" ");
        String[] leeSchedules = br.readLine().split(" ");
        StringBuilder output = new StringBuilder();
        int remain = 0;

        for (int i = 0; i < kimSchedules.length; i++) {
            int minus = Integer.parseInt(kimSchedules[i]);
            int plus = Integer.parseInt(leeSchedules[i]);

            if (minus > plus) {
                int offset = Math.min(minus - plus, remain);

                output.append(minus - plus - offset).append(" ");
                remain -= offset;
            } else {
                output.append(0).append(" ");
                remain += plus - minus;
            }
        }

        bw.write(output.toString().trim());
        bw.flush();
    }

}
