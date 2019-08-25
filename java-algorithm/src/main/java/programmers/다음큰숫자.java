package programmers;

public class 다음큰숫자 {

    public int solution(int n) {
        int origin = getCountOfOne(n);

        while(true) {
            int target = getCountOfOne(++n);
            if(origin == target) {
                return n;
            }
        }
    }

    private int getCountOfOne(int number) {
        int count = 0;
        String binary = Integer.toBinaryString(number);
        for(char c : binary.toCharArray()) {
            if(c == '1') {
                count++;
            }
        }

        return count;
    }

    // Integer.bitCount() 이용
    public int solution2(int n) {
        int origin = Integer.bitCount(n);

        while(true) {
            int target = Integer.bitCount(++n);
            if(origin == target) {
                return n;
            }
        }
    }

    // 비트연산 이용
    public int solution3(int n) {
        int postPattern = n & -n;
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }

}
