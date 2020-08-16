package ps.kakao.blind20;

import org.junit.Test;

public class 문자열압축 {

    public int solution(String s) {
        int answer = s.length();

        for(int i = 1, limit = s.length() / 2; i <= limit; i++) {
            int position = 0;
            int length = s.length();

            for( ; position + i <= length;) {
                String unit = s.substring(position, position + i);
                position += i;

                int count = 0;
                for( ; position + i <= length;) {
                    if(unit.equals(s.substring(position, position + i))) {
                        ++count;
                        position += i;
                    } else {
                        break;
                    }
                }

                if(count > 0) {
                    length -= i * count;

                    if(count < 9) {
                        length += 1;
                    } else if(count < 99) {
                        length += 2;
                    } else if(count < 999) {
                        length += 3;
                    } else {
                        length += 4;
                    }
                }
            }

            answer = Math.min(answer, length);
        }

        return answer;
    }

    @Test
    public void test() {
        System.out.println(solution("abcabcabcabcdededededede"));
    }

}
