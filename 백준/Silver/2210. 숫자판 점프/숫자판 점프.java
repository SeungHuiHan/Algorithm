import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] board = new int[5][5];
    private static int[] dx = {0, 0, -1, 1}; // 좌우상하
    private static int[] dy = {-1, 1, 0, 0};
    private static Set<String> result = new HashSet<>();

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 칸에서 BFS 시작
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i, j);
            }
        }

        System.out.println(result.size());
    }

    private static void bfs(int x, int y) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y, board[x][y], 1}); // x, y, 숫자값 누적, 깊이

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int cx = cur[0];
            int cy = cur[1];
            String path = String.valueOf(cur[2]);
            int depth = cur[3];

            if (path.length() > 6) continue;
            if (depth == 6) {
                result.add(path);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                deque.add(new int[]{nx, ny, Integer.parseInt(path + board[nx][ny]), depth + 1});
            }
        }
    }
}
