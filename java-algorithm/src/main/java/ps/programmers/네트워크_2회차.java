package ps.programmers;

public class 네트워크_2회차 {

    private static boolean[] visit;

    public int solution(int n, int[][] computers) {
        visit = new boolean[n];

        int result = 0;
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                result++;
                dfs(i, computers);
            }
        }
        return result;
    }

    private void dfs(int index, int[][] computers) {
        visit[index] = true;

        int[] connections = computers[index];
        for(int i = 0; i < connections.length; i++) {
            if(connections[i] == 1 && !visit[i]) {
                dfs(i, computers);
            }
        }
    }

}
