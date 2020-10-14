package etc;

public class GetMaxSum {

    // https://jungmonster.tistory.com/126

    public int dp(int[] arr) {
        int max = Integer.MIN_VALUE;
        int[] cache = new int[arr.length + 1];
        cache[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cache[i] = Math.max(0, cache[i - 1]) + arr[i];
            max = Math.max(max, cache[i]);
        }

        return max;
    }

}
