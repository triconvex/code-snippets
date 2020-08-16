//package ps.programmers;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//public class 컬러링북 {
//
//    public int[] solution(int m, int n, int[][] picture) {
//        boolean[][] visit = new boolean[m][n];
//        List<Integer> results = new ArrayList<>();
//
//        for(int i = 0; i < picture.length; i++) {
//            for(int j = 0; j < picture[0].length; j++) {
//                results.add(bfs(picture, i, j, visit, 0));
//            }
//        }
//
//        System.out.println(results.size());
//        System.out.println(results.stream().max(Comparator.comparing(Integer::valueOf)));
//
//        return null;
//    }
//
//    private int bfs(int[][] picture, int i, int j, boolean[][] visit, int sum) {
//        if(visit[i][j]) {
//            return sum;
//        }
//    }
//
//}
