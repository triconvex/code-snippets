package ps.boj.입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10952 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(line);
            int sum = Integer.parseInt(stk.nextToken()) + Integer.parseInt(stk.nextToken());
            if(sum == 0) {
                return;
            }
            System.out.println(sum);
        }
    }

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        while(flag) {
            String str = br.readLine();
            char ch1 = str.charAt(0);
            char ch2 = str.charAt(2);

            if(ch1 == '0' && ch2 == '0')
                flag = false;
            else
                System.out.println(ch1 - '0' + ch2 - '0');
        }
    }

}
