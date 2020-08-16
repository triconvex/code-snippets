package ps.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4963_섬의_개수_dfs {

    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer spec = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(spec.nextToken());
            int height = Integer.parseInt(spec.nextToken());

            if(width == 0 && height == 0) {
                return;
            }

            String[][] islands = new String[height][width];
            visit = new boolean[height][width];

            for(int i = 0; i < height; i++) {
                islands[i] = br.readLine().split(" ");
            }

            int result = 0;
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    if(!visit[i][j] && islands[i][j].equals("1")) {
                        result++;
                        dfs(i, j, islands);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(int height, int width, String[][] islands) {
        if(height < 0 || width < 0 || height >= islands.length || width >= islands[0].length) {
            return;
        }

        if(visit[height][width]) {
            return;
        }

        if(islands[height][width].equals("0")) {
            return;
        }

        visit[height][width] = true;

        dfs(height + 1, width, islands);
        dfs(height, width + 1, islands);
        dfs(height - 1, width, islands);
        dfs(height, width - 1, islands);
        dfs(height + 1, width + 1, islands);
        dfs(height - 1, width - 1, islands);
        dfs(height - 1, width + 1, islands);
        dfs(height + 1, width - 1, islands);
    }

}
