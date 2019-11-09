package leetcode;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    // TODO : google https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/163698/easy-java-Bellman-Ford
    //  Bellman-Ford 풀이, 이해안됨
    //  벨만포드는 음의 가중치를 고려할 때, 아래 문제를 다익스트라로 접근해보기
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] target = new int[n];
        Arrays.fill(target, Integer.MAX_VALUE);
        target[src] = 0;

        for(int i = 0; i < K + 1; i++) {
            int[] temp = Arrays.copyOf(target, n);
            for(int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                if(target[from] == Integer.MAX_VALUE) {
                    continue;
                }

                if(temp[to] > target[from] + cost) {
                    temp[to] = target[from] + cost;
                }
            }

            target = temp;
        }

        return target[dst] == Integer.MAX_VALUE ? -1 : target[dst];
    }

}
