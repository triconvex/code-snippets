package bit;

// https://youtu.be/yHBYeguDR0A
public class BitOperation {

    static int clearBit(int num, int i) {
        return num & ~(1 << i);
        /*
            1을 i만큼 left shift <- index i번째만 켜진 비트
            그리고 ~ (not)으로 정반대값으로
            이걸 원본 num과 AND연산하면 index의 비트만 꺼지고 나머지값들은 그대로 내려온다
            i번째 bit만 0으로
         */
    }

    static int clearLeftBits(int num, int i) {
        return num & ((1 << i) - 1);
        /*
            1을 i만큼 left shift <- index i번째만 켜진 비트
            그리고 1을 빼면 index - 1까지만 켜지고 나머지는 꺼진 비트
            이걸 원본 num과 AND연산하면 index포함 왼쪽의 비트는 모두 꺼진다
         */
    }

    static int clearRightBits(int num, int i) {
        return num & (-1 << (i + 1));
//        return num >> i + 1 << i + 1; <- 이렇게 하는 건 어떤가?
    }

    public static void main(String[] args) {
        // 1001
        // 0001
        System.out.println("clearBit(9, 3) = " + clearBit(9, 3));

        // 10101001
        // 00000001
        System.out.println("clearLeftBits(169, 3) = " + clearLeftBits(169, 3));

        // 10101001
        // 10100001
        System.out.println("clearRightBits(169, 3) = " + clearRightBits(169, 3));
    }

}
