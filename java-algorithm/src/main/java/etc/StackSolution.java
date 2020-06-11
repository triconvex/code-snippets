package etc;

import java.util.Stack;

public class StackSolution {

    public static void main(String[] args) {
        String validInput = "(var x = {y: [1, 2, 3]})";
        System.out.println("verifyWithStack(validInput) = " + verifyWithStack(validInput));
        String invalidInput = "(var x = }{y: [1, 2, 3]})";
        System.out.println("verifyWithStack(invalidInput) = " + verifyWithStack(invalidInput));
    }

    private static boolean verifyWithStack(String target) {
        Stack<Character> stack = new Stack<>();
        for (char c : target.toCharArray()) {
            if(isOpeningBrace(c)) {
                stack.push(c);
            }
            if(isClosingBrace(c)) {
                if(!stack.isEmpty() && stack.peek() == openingBraceOf(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpeningBrace(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    private static boolean isClosingBrace(char c) {
        return c == ']' || c == '}' || c == ')';
    }

    private static char openingBraceOf(char c) {
        if(c == ']') {
            return '[';
        }
        if(c == '}') {
            return '{';
        }
        if(c== ')') {
            return '(';
        }
        throw new IllegalArgumentException();
    }

}
