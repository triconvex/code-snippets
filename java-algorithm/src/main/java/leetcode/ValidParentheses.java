package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '[') {
                brackets.push(']');
            } else if(c == '{') {
                brackets.push('}');
            } else if(c == '(') {
                brackets.push(')');
            } else if(brackets.isEmpty() || brackets.pop() != c) {
                return false;
            }
        }

        return brackets.isEmpty();
    }

    public boolean isValid2(String s) {
        char[] stack = new char[s.length()];
        int head = 0;

        for(char c : s.toCharArray()) {
            if(c == '[') {
                stack[head++] = ']';
            } else if(c == '{') {
                stack[head++] = '}';
            } else if(c == '(') {
                stack[head++] = ')';
            } else if(head == 0 || stack[head--] != c) {
                return false;
            }
        }

        return head == 0;
    }

}