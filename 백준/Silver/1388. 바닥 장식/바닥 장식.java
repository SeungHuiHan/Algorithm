import java.util.*;
import java.io.*;

public class Main {
    private static char[][] maps;
    private static boolean[][] visited;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        if (maps[x][y] == '-') {
            int ny = y + 1;
            while (ny < M && maps[x][ny] == '-' && !visited[x][ny]) {
                visited[x][ny] = true;
                ny++;
            }
        } else if (maps[x][y] == '|') {
            int nx = x + 1;
            while (nx < N && maps[nx][y] == '|' && !visited[nx][y]) {
                visited[nx][y] = true;
                nx++;
            }
        }
    }
}
