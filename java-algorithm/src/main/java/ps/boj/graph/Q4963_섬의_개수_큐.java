package ps.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4963_섬의_개수_큐 {

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
                        bfs(i, j, islands);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void bfs(int height, int width, String[][] islands) {
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(height, width));

        while(!points.isEmpty()) {
            Point current = points.poll();
            int h = current.x;
            int w = current.y;
            if(current.isNotValid(islands.length - 1, islands[0].length - 1)) {
                continue;
            }
            if(visit[h][w]) {
                continue;
            }
            if(islands[h][w].equals("0")) {
                continue;
            }
            visit[h][w] = true;

            points.add(new Point(h - 1, w));
            points.add(new Point(h - 1, w + 1));
            points.add(new Point(h, w + 1));
            points.add(new Point(h + 1, w + 1));
            points.add(new Point(h + 1, w));
            points.add(new Point(h + 1, w - 1));
            points.add(new Point(h, w - 1));
            points.add(new Point(h - 1, w - 1));
        }
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isNotValid(int limitX, int limitY) {
            return x < 0 || y < 0 || x > limitX || y > limitY;
        }
    }

}
