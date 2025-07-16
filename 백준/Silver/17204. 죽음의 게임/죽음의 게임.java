import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int current, int depth) {
        if (depth > N) return -1; // 사이클 가능성 차단
        if (current == K) return depth;
        return dfs(arr[current], depth + 1);
    }
}
