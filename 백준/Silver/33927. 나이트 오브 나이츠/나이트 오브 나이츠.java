import java.util.*;

public class Main {
    private static int N;
    private static int[][] board;
    private static boolean[][] visited;
    private static int maxScore = 0;
    
    // 나이트 이동 8방향
    private static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        backtrack(0, 0, 0);
        System.out.println(maxScore);
    }

    // (x,y)부터 체스판을 순회하며 최대 점수 탐색
    private static void backtrack(int x, int y, int score) {
        // 다음 행으로 이동
        if (y == N) {
            x++;
            y = 0;
        }

        // 체스판 끝에 도달했으면 최대값 갱신
        if (x == N) {
            maxScore = Math.max(maxScore, score);
            return;
        }

        // 현재 칸에 나이트를 놓을 수 있는 경우
        if (canPlace(x, y)) {
            visited[x][y] = true;
            backtrack(x, y + 1, score + board[x][y]); // 나이트를 놓고 다음 칸으로
            visited[x][y] = false;
        }

        // 현재 칸에 나이트를 놓지 않는 경우
        backtrack(x, y + 1, score);
    }

    // 나이트를 놓을 수 있는지 확인
    private static boolean canPlace(int x, int y) {
        if (visited[x][y]) return false;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (visited[nx][ny]) return false;
            }
        }
        return true;
    }
}
