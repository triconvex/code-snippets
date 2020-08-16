package ps.boj.입출력;

import java.io.*;

public class Q11021 {

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfInput = Integer.parseInt(br.readLine());

        for(int i = 0; i < numberOfInput; i++) {
            String input = br.readLine();
            int output = input.charAt(0) + input.charAt(2) - 0x60;

            bw.write("Case #" + (i + 1) + ": " + output + "\n");
        }

        bw.flush();
        bw.close();
    }

}
