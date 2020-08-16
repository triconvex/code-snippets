package ps.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 섬연결하기 {

    public int solution(int n, int[][] costs) {
        int answer = 0;

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Bridge> bridges = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for(int[] cost : costs) {
            bridges.add(new Bridge(cost[0], cost[1], cost[2]));
        }

        while(!bridges.isEmpty()) {
            Bridge bridge = bridges.poll();
            if(!findParent(parent, bridge.from, bridge.to)) {
                answer += bridge.cost;
                unionParent(parent, bridge.from, bridge.to);
            }
        }

        return answer;
    }

    private int getParent(int[] parent, int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = getParent(parent, parent[x]);
    }

    private void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        return a == b;
    }

    private static class Bridge {
        int from;
        int to;
        int cost;

        Bridge(int from, int to, int cost) {
            this.from = Math.min(from, to);
            this.to = Math.max(from, to);
            this.cost = cost;
        }
    }

}
