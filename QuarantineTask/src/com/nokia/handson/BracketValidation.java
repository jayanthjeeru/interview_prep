package com.nokia.handson;

import java.util.Stack;

public class BracketValidation {
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Handle closing brackets
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack should be empty if all brackets are matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "()[]{}";
        String input2 = "([)]";
        String input3 = "{[]}";

        System.out.println(isValid(input1)); // true
        System.out.println(isValid(input2)); // false
        System.out.println(isValid(input3)); // true
    }
}
