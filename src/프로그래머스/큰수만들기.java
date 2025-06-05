package 프로그래머스;

import java.util.Stack;

public class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0) {
                if (stack.peek() >= c)
                    break;
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        for (Character c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String solution = new 큰수만들기().solution("4177252841", 4);
        System.out.println(solution);
    }
}
