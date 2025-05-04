import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 버스 개수
        int T = sc.nextInt();  // 영식이 도착 시간
        int minWait = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt(); // 시작 시간
            int I = sc.nextInt(); // 간격
            int C = sc.nextInt(); // 대수

            for (int j = 0; j < C; j++) {
                int departure = S + j * I;

                if (departure >= T) {
                    minWait = Math.min(minWait, departure - T);
                    break;  // 더 이후 버스는 더 늦게 출발하므로 볼 필요 없음
                }
            }
        }

        if (minWait == Integer.MAX_VALUE) {
            System.out.println(-1);  // 탈 수 있는 버스 없음
        } else {
            System.out.println(minWait);
        }
    }
}
