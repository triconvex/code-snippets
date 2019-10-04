package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completedPlayers = new HashMap<>();

        for(String player : completion) {
            completedPlayers.put(player, completedPlayers.getOrDefault(player, 0) + 1);
        }

        for(String player : participant) {
            int count = completedPlayers.getOrDefault(player, 0) - 1;

            if(count < 0) {
                return player;
            }

            completedPlayers.put(player, count);
        }

        return "";
    }

}
