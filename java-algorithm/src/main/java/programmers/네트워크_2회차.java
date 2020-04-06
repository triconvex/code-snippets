package programmers;

public class 네트워크_2회차 {

    private static boolean[] visit;

    public int solution(int n, int[][] computers) {
        visit = new boolean[n];

        int result = 0;
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                result++;
                dfs(computers, i);
            }
        }
        return result;
    }

    private void dfs(int[][] computers, int i) {
        visit[i] = true;

        int[] connections = computers[i];
        for(int j = 0; j < connections.length; j++) {
            if(connections[j] == 1 && !visit[j]) {
                dfs(computers, j);
            }
        }
    }

}
