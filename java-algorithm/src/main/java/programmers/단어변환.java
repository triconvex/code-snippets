package programmers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class 단어변환 {

    private int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        if(Arrays.stream(words).noneMatch(word -> word.equals(target))) {
            return 0;
        }

        List<Word> wordList = new ArrayList<>();
        for(String word : words) {
            wordList.add(new Word(word));
        }

        dfs(0, new Word(begin), new Word(target), wordList);
        return answer;
    }

    private void dfs(int count, Word current, Word target, List<Word> words) {
        if(count > words.size() || current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        current.visit = true;
        for(Word word : words) {
            if(!word.visit && current.isConvertible(word)) {
                dfs(count + 1, word, target, words);
            }
        }
    }

    private class Word {

        private String word;
        private boolean visit = false;

        public Word(String word) {
            this.word = word;
        }

        public boolean isConvertible(Word target) {
            int count = 0;

            for(int i = 0; i < word.length(); i++) {
                if(word.charAt(i) != target.word.charAt(i)) {
                    count++;
                }
            }

            return count == 1;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Word)) return false;
            Word word1 = (Word) o;
            return Objects.equals(word, word1.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

    }

}
