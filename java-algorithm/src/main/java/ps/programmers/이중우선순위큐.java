package ps.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();

        for(String operation : operations) {
            int value = Integer.parseInt(operation.split(" ")[1]);

            if(operation.startsWith("I")) {
                maxPriorityQueue.add(value);
                minPriorityQueue.add(value);
            } else {
                if(!maxPriorityQueue.isEmpty()) {
                    if(value == 1) {
                        int max = maxPriorityQueue.peek();
                        maxPriorityQueue.remove(max);
                        minPriorityQueue.remove(max);
                    } else {
                        int min = minPriorityQueue.peek();
                        maxPriorityQueue.remove(min);
                        minPriorityQueue.remove(min);
                    }
                }
            }
        }

        return new int[]
                {
                        maxPriorityQueue.isEmpty() ? 0 : maxPriorityQueue.poll(),
                        minPriorityQueue.isEmpty() ? 0 : minPriorityQueue.poll()
                };
    }

}
