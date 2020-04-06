package programmers;

import java.util.Stack;

public class 네트워크_스택 {

    private static boolean[] visit;

    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        int result = 0;

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                result++;

                Stack<Integer> indices = new Stack<>();
                indices.add(i);

                while(!indices.empty()) {
                    int index = indices.pop();
                    visit[index] = true;

                    int[] connections = computers[index];
                    for(int j = 0; j < n; j++) {
                        if(connections[j] == 1 && !visit[j]) {
                            indices.add(j);
                        }
                    }
                }
            }
        }
        return result;
    }

}
