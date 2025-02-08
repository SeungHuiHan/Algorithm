import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static boolean[] visited;
    private static int[] arr;
    private static String s;
    private static int n;
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        n = s.length();
        arr = new int[n];
        visited = new boolean[n];

        backtracking(0, 0);

        System.out.println(set.size());
    }

    private static void backtracking(int index, int count) {
        if (count == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(arr[i]) == s.charAt(arr[i + 1])) { // 여기서 arr[i+1] 접근 가능성 문제 해결
                    return;
                }
                sb.append(s.charAt(arr[i]));
            }
            
            sb.append(s.charAt(arr[n - 1])); // 마지막 문자 추가

            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[index] = i;
                backtracking(index + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}
