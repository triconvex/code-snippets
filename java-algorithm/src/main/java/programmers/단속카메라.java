package programmers;

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

}
