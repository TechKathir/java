package stack;


import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        String d = "[[{}]()]";
        System.out.println("valid - " + isValid(d));
    }

    public static boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            System.out.println("---- " + current);
            if (characters.isEmpty()) {
                if (!isOpenBracket(current)) {
                    characters.push(current);
                    break;
                }
                System.out.println("push - " + current);
                characters.push(current);
            } else if (isOpenBracket(current)) {
                System.out.println("push - " + current);
                characters.push(current);
            } else {
                Character previous = characters.peek();
                System.out.println("previous - " + previous);
                if (isOpenBracket(previous) && !isOpenBracket(current)) {
                    System.out.println("reverse - " + getReverseBracket(current));
                }
                if (isOpenBracket(previous) && !isOpenBracket(current) && previous.equals(getReverseBracket(current))) {
                    System.out.println("pop - " + characters.pop());
                } else {
                    System.out.println("push - " + current);
                    characters.push(current);
                }
            }
        }
        return characters.isEmpty();
    }

    public static boolean isOpenBracket(Character c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static Character getReverseBracket(Character c) {
        if (c == '}') return '{';
        if (c == ']') return '[';
        if (c == ')') return '(';
        return null;
    }
}

/*
 * first elemet close break and invalid
 * is open add to stack
 *  chekc pre stack with current char equals pop else push
 * */