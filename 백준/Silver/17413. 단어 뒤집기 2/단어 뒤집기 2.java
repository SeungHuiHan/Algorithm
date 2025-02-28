import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String s = bf.readLine();
        boolean isTag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) { // 단어가 끝났다면 뒤집어서 추가
                    result.append(stack.pop());
                }
                isTag = true; // 태그 시작
                result.append(c);
            } else if (c == '>') {
                isTag = false; // 태그 종료
                result.append(c);
            } else if (isTag) {
                result.append(c); // 태그 내부는 그대로 유지
            } else if (c == ' ') {
                while (!stack.isEmpty()) { // 단어 뒤집기
                    result.append(stack.pop());
                }
                result.append(' '); // 공백 추가
            } else {
                stack.push(c); // 단어 저장 (뒤집기 위해 스택 사용)
            }
        }

        // 마지막 단어 뒤집기 (스택에 남아 있는 단어 처리)
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result);
    }
}
