package programmers;

public class JadenCase문자열만들기 {

    public String solution(String s) {
        String[] letters = s.toLowerCase().split("");
        boolean flag = true;

        for(int i = 0; i < letters.length; i++) {
            if(flag) {
                letters[i] = letters[i].toUpperCase();
            }

            flag = letters[i].equals(" ");
        }

        return String.join("", letters);
    }

}
