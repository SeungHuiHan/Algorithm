import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int[][] locations;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(bf.readLine()); // 편의점 수
            locations = new int[n + 2][2]; // [0] = 집, [1~n] = 편의점, [n+1] = 페스티벌
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                locations[i][0] = Integer.parseInt(st.nextToken()); // x
                locations[i][1] = Integer.parseInt(st.nextToken()); // y
            }

            sb.append(bfs() ? "happy\n" : "sad\n");
        }

        System.out.print(sb);
    }

    // BFS 탐색
    private static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0); // 시작점 (상근이네 집)
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] now = locations[current];

            for (int i = 0; i < locations.length; i++) {
                if (!visited[i] && distance(now, locations[i]) <= 1000) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        return visited[locations.length - 1]; // 도착점(페스티벌)에 도착했는지 확인
    }

    // 맨해튼 거리 계산
    private static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}