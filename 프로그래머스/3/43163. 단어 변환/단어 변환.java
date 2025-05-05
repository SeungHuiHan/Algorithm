import java.util.*;

class Solution {
    
    private static ArrayDeque<String> deque=new ArrayDeque<>();
    private static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        boolean canTransform = false;
        for (String word : words) {
            if (word.equals(target)) {
                canTransform = true;
                break;
            }
        }
        if (!canTransform) return 0;
        visited = new boolean[words.length];
        return bfs(begin, target, words);
    }
    
    private static int bfs(String begin, String target, String[] words) {
    
    deque.offer(begin);
    int depth = 0;

    while (!deque.isEmpty()) {
        depth++;

        for (int s = 0; s < deque.size(); s++) {
            String current = deque.poll();
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(current, words[i])) {
                    if (words[i].equals(target)) return depth;
                    visited[i] = true;
                    deque.offer(words[i]);
                }
            }
        }
    }

    return 0; // target으로 못 가는 경우
}
    
    private static boolean check(String a, String b) {
    int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count == 1;
    }
}