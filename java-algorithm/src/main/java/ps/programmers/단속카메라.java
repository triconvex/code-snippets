package ps.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 단속카메라 {

    public int solution(int[][] routes) {
        int result = 0;
        int nearestCamera = Integer.MIN_VALUE;

        PriorityQueue<Route> targetRoutes = new PriorityQueue<>();
        for(int[] route : routes) {
            targetRoutes.add(new Route(route[0], route[1]));
        }

        while(!targetRoutes.isEmpty()) {
            Route current = targetRoutes.poll();
            if(!current.isConfirmed(nearestCamera)) {
                result++;
                nearestCamera = current.end;
            }
        }

        return result;
    }

    private class Route implements Comparable<Route> {
        private final int begin;
        private final int end;

        public Route(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        private boolean isConfirmed(int nearestCamera) {
            return nearestCamera >= begin;
        }

        @Override
        public int compareTo(Route target) {
            return this.end - target.end;
        }
    }

    /*
        TODO : 참고풀이
        람다식 comparator
        ++ans 전위연산 이유? 필요성?
     */

    public int 참고풀이(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {
                ++ans;
                last_camera = a[1];
            }
        }
        return ans;
    }

}
