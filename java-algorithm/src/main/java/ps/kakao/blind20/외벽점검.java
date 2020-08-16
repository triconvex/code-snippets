package ps.kakao.blind20;

import org.junit.Test;

//public class 외벽점검 {
//
////    public int solution(int n, int[] weak, int[] dist) {
////        if(weak.length == 1) {
////            return 1;
////        }
////
////        int answer = Integer.MAX_VALUE;
////
////        List<Integer> weakPositions = new LinkedList<>();
////        for(int i : weak) {
////            weakPositions.add(i);
////        }
////
////        List<Integer> distances = new ArrayList<>();
////        for(int i : dist) {
////            distances.add(i);
////        }
////        distances.sort(Comparator.reverseOrder());
////
////        Set<List<Integer>> permutations = permute(distances);
////        System.out.println("permutations :: " + permutations);
////
////        for(int i = 0; i <= weakPositions.size(); i++) {
////            System.out.println("@@@@@@@@@@@@@@@@");
////            System.out.println("weakPositions = " + weakPositions);
////            System.out.println("@@@@@@@@@@@@@@@@");
////            for(List<Integer> permutation : permutations) {
////                if(permutation.size() >= answer) {
////                    break;
////                }
////                System.out.println("permutation = " + permutation);
////                int ret = getAnswer(weakPositions, permutation);
////                if(ret != -1) {
////                    System.out.println(" ***** ret = " + ret);
////                    answer = Math.min(answer, ret);
////                    break;
////                }
////            }
////            weakPositions.add(weakPositions.remove(0) + n);
////        }
////        if(answer >= 9) {
////            return -1;
////        }
////        return answer == Integer.MAX_VALUE ? -1 : answer;
////    }
////
////    private int getAnswer(final List<Integer> weakPositions, List<Integer> permutation) {
////        Queue<Integer> weakPositionQueue = new LinkedList<>(weakPositions);
////        int count = 0;
////        for(Integer distance : permutation) {
////            if(weakPositionQueue.isEmpty()) {
////                break;
////            }
////            int startPosition = weakPositionQueue.poll();
////            System.out.print("removed = " + startPosition + " ");
////            int movedPosition = startPosition + distance;
////
////            while(!weakPositionQueue.isEmpty() && movedPosition >= weakPositionQueue.peek()) {
////                int removed = weakPositionQueue.poll();
////                System.out.print("removed = " + removed + " ");
////            }
////            count++;
////        }
////        System.out.println("\nremained weakPositions = " + weakPositionQueue);
////        System.out.println("-----------------------------");
////        return weakPositionQueue.isEmpty() ? count : -1;
////    }
//
//    private Set<List<Integer>> permute(List<Integer> numbers) {
//        boolean[] visit = new boolean[numbers.size()];
//        Set<List<Integer>> result = new HashSet<>();
//        List<Integer> temp = new LinkedList<>();
//
//        for(int i = 1; i <= numbers.size(); i++) {
//            backtrack(numbers, result, temp, visit, i);
//        }
//
//        System.out.println(result);
//        return result;
//    }
//
//    private void backtrack(List<Integer> numbers, Set<List<Integer>> result, List<Integer> temp, boolean[] visit, int depth) {
//        if(temp.size() == depth) {
//            System.out.println(temp);
//            result.add(new LinkedList<>(temp));
//            return;
//        }
//
//        for(int i = 0; i < numbers.size(); i++) {
//            int index = i;
//            while(index < numbers.size()) {
//                if(!visit[index]) {
//                    temp.add(numbers.get(i));
//                    visit[i] = true;
//                    break;
//                }
//
//                index++;
//            }
//
//            backtrack(numbers, result, temp, visit, depth);
//
//            temp.remove(temp.size() - 1);
//            visit[i] = false;
//        }
//    }
//
//    @Test
//    public void test() {
////        int n = 12;
////        int[] weak = {1, 5, 6, 10};
////        int[] dist = {1, 2, 3, 4};
//
////        int n = 12;
////        int[] weak = {1, 3, 4, 9, 10};
////        int[] dist = {3, 5, 7};
//
////        int n = 50;
////        int[] weak = {1, 5, 10, 12, 22, 25};
////        int[] dist = {4, 3, 2, 1};
//
////        int n = 30;
////        int[] weak = {0, 3, 11, 21};
////        int[] dist = {10, 4};
//
////        int n = 50;
////        int[] weak = {1};
////        int[] dist = {6};
//
////        int n = 50;
////        int[] weak = {1, 2, 3, 4, 5};
////        int[] dist = {3, 4, 6};
//
////        int[] weak = {0, 99, 199};
////        int[] dist = {1, 100};
//
//        int n = 10;
//        int[] weak = {0, 3, 5};
//        int[] dist = {3, 3};
//
//        System.out.println(1 << 0);
//        System.out.println(1 << 1);
//        System.out.println(1 << 2);
//        System.out.println(1 << 3);
//        System.out.println(16 >> 1);
//        System.out.println(16 >> 2);
//        System.out.println(16 >> 3);
//        System.out.println(16 >> 4);
//
////        System.out.println(solution(n, weak, dist));
//    }
//
//    @Test
//    public void permutationTest() {
//        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4));
//        permute(numbers);
//    }
//}

public class 외벽점검 {
    int N = 0;
    int ans = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        //dist 오름차순 정렬
        java.util.Arrays.sort(dist);

        //dist 내림차순 정렬
        for (int i = 0; i < dist.length / 2; i++) {
            int temp = dist[i];
            dist[i] = dist[dist.length - 1 - i];
            dist[dist.length - 1 - i] = temp;
        }

        this.N = n;
        int min = Integer.MAX_VALUE;
        dfs(0, weak, dist, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int d, int[] weak, int[] dist, int visited) {
        // base case
        // visited (점검한 외벽의 수)가 1 << 취약점 길이 - 1 과 같으면 아웃
        // 1 << weak.length
        // 1을 weak.length 만큼 왼쪽으로 쉬프트하니까... (2의 weak.length 제곱 - 1)

        System.out.println("((1 << weak.length) - 1 = " + ((1 << weak.length) - 1));
        if (visited == ((1 << weak.length) - 1)) {
            ans = Math.min(ans, d);
            return;
        }

        //depth를 의미하는 d일까?
        //dfs를 쌓으면서 d를 0부터 1씩 늘려주는데 d가 dist 길이와 같으면 아웃
        if (d == dist.length) {
            return;
        }

        //취약점 개수만큼 loop

        for (int i = 0; i < weak.length; i++) {

            //점검한 외벽의 수와 2의 i 제곱의 비트AND연산자가 0보다 크면 continue;
            //0보다 작은 경우는 비트 연산 시에 00000000 인데 이걸로 뭘 알 수 있지?
            System.out.println("((1 << weak.length) - 1 = " + (1 << i));
            if ((visited & (1 << i)) > 0) {
                continue;
            }
            java.util.Set<Integer> set = new java.util.HashSet<>();

            //취약점 개수만큼 이중 loop
            for (int j = 0; j < weak.length; j++) {

                //k는 이중루프에서 i + j의 합이 취약점의 개수보다 크면 n 취약점개수를 빼고, 아니면 i + j
                int k = (i + j) >= weak.length ? i + j - weak.length : i + j;

                //점검한 외벽의 수와 2의 k 제곱의 비트AND연산자가 0보다 크면 continue;
                if ((visited & (1 << k)) > 0) {
                    continue;
                }
                int diff = weak[k] - weak[i];
                if (diff < 0) {
                    diff += N;
                }
                if (diff <= dist[d]) {
                    set.add(k);
                    visited = visited | (1 << k);
                } else {
                    break;
                }
            }
            dfs(d+1, weak, dist, visited);
            for (int v : set) {
                visited = visited & ~(1 << v);
            }
        }
    }

    @Test
    public void permutationTest() {
        int n = 10;
        int[] weak = {0, 3, 5};
        int[] dist = {3, 3};
        solution(n, weak, dist);
    }
}
