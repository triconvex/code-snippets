package ps.programmers;

public class N개의최소공배수 {

    public int solution(int[] arr) {
        int[] targets = {2, 3, 5, 7};
        int[] result = new int[4];

        for(int i : arr) {
            int[] temp = new int[4];

            while(i != 1) {
                for(int j = 0; j < targets.length; j++) {
                    if(i % targets[i] == 0) {
                        i /= targets[i];
                        temp[i]++;
                    }
                }
            }

            for(int j = 0; j < temp.length; j++) {
                result[i] = Math.max(result[i], temp[i]);
            }
        }

        int sum = 0;
        for(int i = 0; i < 4; i++) {
            sum += targets[i] * result[i];
        }

        return sum;
    }

}
