//package ps.boj.greedy;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Q11848_Schools {
//
//    public static void main(String[] args) throws IOException {
//        int N = Integer.parseInt(input[0]);
//        int M = Integer.parseInt(input[1]);
//        int S = Integer.parseInt(input[2]);
//
//        List<Applicant> applicantList = new LinkedList<>();
//
//        for(int i = 0; i < N; i++) {
//            StringTokenizer stk = new StringTokenizer(br.readLine());
//            applicantList.add(new Applicant(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
//        }
//
//        applicantList.sort(Comparator.comparing(Applicant::getA).reversed());
//
//
//    }
//
//    static class Applicant {
//        private int A;
//        private int B;
//
//        public Applicant(int a, int b) {
//            A = a;
//            B = b;
//        }
//
//        public int getA() {
//            return A;
//        }
//
//        public int getB() {
//            return B;
//        }
//    }
//
//    //if there's only one biggest value
//
//
//}
