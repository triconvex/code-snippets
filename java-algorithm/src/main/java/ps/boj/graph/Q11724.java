package ps.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11724 {

    private static int N, M, answer;
    private static boolean[] visit;
    private static boolean[][] edge;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        answer = 0;

        visit = new boolean[N + 1];
        edge = new boolean[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            edge[a][b] = true;
            edge[b][a] = true;
        }

        for(int i = 1; i < N + 1; i++) {
            if(!visit[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int index) {
        for(int i = 1; i <= N; i++) {
            if(visit[i]) {
                continue;
            }

            if(edge[index][i]) {
                dfs(i);
            }
        }
    }

}
