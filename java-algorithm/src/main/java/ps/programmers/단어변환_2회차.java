package ps.programmers;

import java.util.Arrays;

public class 단어변환_2회차 {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        for(int i = 0; i < words.length; i++) {
            boolean[] visit = new boolean[words.length];
            Arrays.fill(visit, false);
            if(isChangeable(begin, words[i])) {
                visit[i] = true;
                next(words[i], target, words, visit);
            }
        }
        return answer;
    }

    private int next(String origin, String target, String[] words, boolean[] visit) {



        return 0;
    }

    private boolean isChangeable(String origin, String target) {
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(origin.indexOf(i) != target.indexOf(i)) {
                count++;
            }
        }
        return count == 1;
    }


}
