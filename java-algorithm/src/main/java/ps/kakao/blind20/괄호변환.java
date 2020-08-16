package ps.kakao.blind20;

public class 괄호변환 {

    public String solution(String p) {
        return getRefinedParenthesisString(p);
    }

    private String getRefinedParenthesisString(String target) {
        if(isValid(target)) {
            return target;
        }
        String answer = "";
        String u = "";
        String v = "";

        for(int i = 2; i < target.length(); i += 2) {
            if(isBalanced(target.substring(0, i))) {
                u = target.substring(0, i);
                v = target.substring(i);
                break;
            }
        }

        if(u.isEmpty()) {
            u = target;
        }

        if(isValid(u)) {
            answer += u + getRefinedParenthesisString(v);
        } else {
            answer += "(" + getRefinedParenthesisString(v) + ")" + sliceSidesAndReverseParenthesis(u);
        }
        return answer;
    }

    private boolean isBalanced(String target) {
        int count = 0;
        for(char c : target.toCharArray()) {
            if(c == '(') {
                count++;
            } else {
                count--;
            }
        }
        return count == 0;
    }

    private boolean isValid(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count++;
            } else {
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private String sliceSidesAndReverseParenthesis(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < s.length() - 1; i++) {
            if(s.charAt(i) == '(') {
                result.append(")");
            } else {
                result.append("(");
            }
        }
        return result.toString();
    }

}

