package programmers;

import org.junit.Test;

import java.util.*;

public class 여행경로 {

    public String[] solution(String[][] tickets) {
        List<Ticket> given = new ArrayList<>();
        for(String[] ticket : tickets) {
            given.add(new Ticket(ticket[0], ticket[1]));
        }

        List<List<Ticket>> result = new ArrayList<>();
        List<Ticket> temp = new ArrayList<>();

        for(Ticket ticket : given) {
            if(ticket.departure.equals("ICN")) {
                temp.add(ticket);
                backtrack(given, result, temp);
                temp.remove(ticket);
            }
        }

        result.sort(new TicketListComparator<>());

        return convertToArray(result.get(0));
    }

    private void backtrack(List<Ticket> given, List<List<Ticket>> result, List<Ticket> temp) {
        if(temp.size() == given.size()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(Ticket ticket : given) {
            if(temp.contains(ticket)) {
                continue;
            }

            if(temp.get(temp.size() - 1).isReachable(ticket)) {
                temp.add(ticket);
                backtrack(given, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private String[] convertToArray(List<Ticket> result) {
        List<String> answer = new ArrayList<>();
        answer.add("ICN");
        for(Ticket ticket : result) {
            answer.add(ticket.arrival);
        }

        return answer.toArray(new String[0]);
    }

    public class Ticket implements Comparable<Ticket> {

        private String departure;
        private String arrival;

        public Ticket(String departure, String arrival) {
            this.departure = departure;
            this.arrival = arrival;
        }

        public boolean isReachable(Ticket target) {
            return this.arrival.equals(target.departure);
        }

        @Override
        public int compareTo(Ticket target) {
            return this.departure.compareTo(target.departure);
        }

    }

    public class TicketListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
        @Override
        public int compare(List<T> o1, List<T> o2) {
            for(int i = 0, size = o1.size(); i < size; i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if(c != 0) {
                    return c;
                }
            }

            return 0;
        }
    }

    @Test
    public void test() {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println(Arrays.toString(solution(tickets)));
    }

}
