package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        String answer = "";

        Arrays.sort(words);

        Set<String> built = new HashSet<>();
        for(String word : words) {
            if(word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                answer = (word.length() > answer.length()) ? word : answer;
                built.add(word);
            }
        }

        return answer;
    }

}
