package ps.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_DFS_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer spec = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(spec.nextToken());
        int M = Integer.parseInt(spec.nextToken());
        int V = Integer.parseInt(spec.nextToken());

        AdjacencyList adjacencyList = new AdjacencyList(N);
        for (int i = 0; i < M; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            adjacencyList.put(x, y);
        }

        dfs(adjacencyList, new boolean[N + 1], V);
        System.out.println();
        bfs(adjacencyList, new boolean[N + 1], V);
    }

    private static void dfs(AdjacencyList adjacencyList, boolean[] visit, int index) {
        if(visit[index]) {
            return;
        }
        System.out.print(index + " ");
        visit[index] = true;

        List<Integer> connectedNodes = adjacencyList.get(index);
        Collections.sort(connectedNodes);

        for (Integer connectedNode : connectedNodes) {
            dfs(adjacencyList, visit, connectedNode);
        }
    }

    private static void bfs(AdjacencyList adjacencyList, boolean[] visit, int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visit[index] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            List<Integer> connectedNodes = adjacencyList.get(current);
            Collections.sort(connectedNodes);

            for (Integer i : connectedNodes) {
                if(!visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }

}

class AdjacencyList {

    private List<List<Integer>> adjacencyList;

    public AdjacencyList(int size) {
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public List<Integer> get(int i) {
        return adjacencyList.get(i);
    }

    public void put(int x, int y) {
        adjacencyList.get(x).add(y);
        adjacencyList.get(y).add(x);
    }

    public void putOneWay(int x, int y) {
        adjacencyList.get(x).add(y);
    }

}