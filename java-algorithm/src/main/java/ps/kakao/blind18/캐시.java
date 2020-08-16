package ps.kakao.blind18;

import java.util.*;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int sum = 0;

        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        List<String> cache = new ArrayList<>();

        String key = cities[0];

        for(String city : cities) {
            cache.add(city);
            if(cache.size() > cacheSize) {
                cache.remove(key);
            }

            if(cache.contains(city)) {
                key = city;
                sum++;
            } else {
                sum += 5;
            }
        }

        return sum;
    }

}
