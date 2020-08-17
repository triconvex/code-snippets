package ps.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1260_DFS와_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int numberOfNodes = Integer.parseInt(stk.nextToken());
        int numberOfEdges = Integer.parseInt(stk.nextToken());
        int startingPoint = Integer.parseInt(stk.nextToken());

        boolean[][] adjacencyMatrix = new boolean[numberOfNodes + 1][numberOfNodes + 1];

        while (numberOfEdges > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int firstNode = Integer.parseInt(stringTokenizer.nextToken());
            int secondNode = Integer.parseInt(stringTokenizer.nextToken());
            adjacencyMatrix[firstNode][secondNode] = true;
            adjacencyMatrix[secondNode][firstNode] = true;
            --numberOfEdges;
        }

        dfs(startingPoint, adjacencyMatrix);
        bfs(startingPoint, adjacencyMatrix);
    }

    //stack or recursion
    private static void dfs(int startingPoint, boolean[][] matrix) {
        StringBuilder result = new StringBuilder();
        boolean[] visit = new boolean[1001];
        Stack<Integer> stack = new Stack<>();

        stack.add(startingPoint);

        while(!stack.isEmpty()) {
            int current = stack.pop();
            if(visit[current]) {
                continue;
            }

            visit[current] = true;
            result.append(current).append(" ");

            for (int i = matrix[current].length - 1; i >= 1; i--) {
                if(matrix[current][i] && !visit[i]) {
                    stack.add(i);
                }
            }
        }

        System.out.println(result.toString().trim());
    }

    //queue
    private static void bfs(int startingPoint, boolean[][] matrix) {
        StringBuilder result = new StringBuilder();
        boolean[] visit = new boolean[1001];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startingPoint);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            visit[current] = true;
            result.append(current).append(" ");

            for (int i = 1; i < matrix[current].length; i++) {
                if(matrix[current][i] && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }

        System.out.println(result.toString().trim());
    }

}
