package leetcode;

public class BinaryGap {

    public int binaryGap(int N) {
        String binaryString = Integer.toBinaryString(N);

        int result = 0;
        int temp = 0;

        for(int i = 1, length = binaryString.length(); i < length; i++) {
            temp++;

            if(binaryString.charAt(i) == '1') {
                result = Math.max(result, temp);
                temp = 0;
            }
        }

        return result;
    }

    // TODO - use bitwise operators!
    public int binaryGap2(int N) {

    }

}
