package programmers;

public class 멀쩡한사각형 {

    public long solution(int w, int h) {
        int gcd = gcd(w, h);
        int unitWidth = w / gcd;
        int unitHeight = h / gcd;
        int sliced = unitWidth + unitHeight - 1;

        return ((long) w * h) - (sliced * gcd);
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

}
