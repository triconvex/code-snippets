package kakao.winterintern19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Test;

public class 불량사용자 {

    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> permutations = getPermutations(new ArrayList<>(Arrays.asList(user_id)), banned_id.length);
        Set<Set<String>> answers = new HashSet<>();

        for (List<String> permutation : permutations) {
            boolean flag = true;
            for (int i = 0; i < banned_id.length; i++) {
                if (!isMatch(permutation.get(i), banned_id[i])) {
                    flag = false;
                }
            }
            if (flag) {
                answers.add(new HashSet<>(permutation));
            }
        }
        return answers.size();
    }

    private boolean isMatch(String normal, String masked) {
        return normal.matches(masked.replaceAll("\\*", "."));
    }

    private List<List<String>> getPermutations(List<String> ids, int depth) {
        List<List<String>> result = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        backtrack(ids, result, temp, depth);
        return result;
    }

    private void backtrack(List<String> ids, List<List<String>> result, List<String> temp, int depth) {
        if (temp.size() == depth) {
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < ids.size(); i++) {
            if (temp.contains(ids.get(i))) {
                continue;
            }
            temp.add(ids.get(i));
            backtrack(ids, result, temp, depth);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test() {
//        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String[] banned_id = {"fr*d*", "abc1**"};

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        System.out.println(solution(user_id, banned_id));
    }

}
