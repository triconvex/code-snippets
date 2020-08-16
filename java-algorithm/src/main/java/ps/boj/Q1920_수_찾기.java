//package ps.boj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.StringTokenizer;
//
//public class Q1920_수_찾기 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
//        StringTokenizer N = new StringTokenizer(br.readLine());
//        br.readLine();
//        String[] M = br.readLine().split(" ");
//
//        Set<String> input = new HashSet<>();
//        while(N.hasMoreTokens()) {
//            input.add(N.nextToken());
//        }
//
//        for(String s : input) {
//
//        }
//
//        while(M.hasMoreTokens()) {
//            String a = M.nextToken();
//            if(input.contains(a)) {
//                System.out.println(1);
//            } else {
//                System.out.println(0);
//            }
//        }
//    }
//}
