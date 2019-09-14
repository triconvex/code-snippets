package programmers;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                dfs(i, computers, visit);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int index, int[][] computers, boolean[] visit) {
        visit[index] = true;
        int[] currentComputer = computers[index];

        for(int i = 0; i < currentComputer.length; i++) {
            if(currentComputer[i] == 1 && !visit[i]) {
                dfs(i, computers, visit);
            }
        }
    }

    @Test
    public void test() {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;

        assertThat(solution(n, computers)).isEqualTo(2);
    }

}
