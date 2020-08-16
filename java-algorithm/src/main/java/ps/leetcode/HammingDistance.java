package ps.leetcode;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
        //https://stackoverflow.com/questions/109023/how-to-count-the-number-of-set-bits-in-a-32-bit-integer
    }

    /*

    a = 3 -> 11
    b = 2 -> 10

    a & b = 10; 두 비트가 모두 1이면 1, 아니면 0
    a | b = 11; 두 비트 중 하나라도 1이면 1, 아니면 0
    a ^ b = 01; 두 비트가 다르면 1, 아니면 0

    a >> 1 = 01; a의 모든 비트를 오른쪽으로 i칸 밀고, 왼쪽을 0으로 채움
    a << 1 = 10; a의 모든 비트를 왼쪽으로 i칸 밀고, 오른쪽을 0으로 채움

     */

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1; // xor의 가장 오른쪽을 1과 비교하여 모두 1이면 1, 아니면 0
                                     // java의 int는 32bit 이므로 32번 우측으로 밀면서 검증
        }

        return count;
    }

}
