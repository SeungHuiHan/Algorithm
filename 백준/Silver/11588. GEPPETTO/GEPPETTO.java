import java.util.*;

public class Main{
    private static int N,M;
    private static ArrayList<Integer> list=new ArrayList<>();
    private static boolean[][] banned; // 금지된 조합 저장
    private static int count;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();

        banned = new boolean[N + 1][N + 1]; // (1 ≤ a, b ≤ N)

        // 금지된 조합 입력 받기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            banned[a][b] = true;
            banned[b][a] = true; // (a, b)와 (b, a)는 동일함
        }

        backtracking(1, new boolean[N + 1]); // 1부터 시작
        System.out.println(count);
    }
    private static void backtracking(int index, boolean[] selected) {
        if (index > N) {
            count++; // 가능한 조합 개수 증가
            return;
        }

        // 현재 `index`를 포함하지 않는 경우도 고려
        backtracking(index + 1, selected);

        // 현재 `index`를 포함하는 경우 (금지된 조합 확인)
        for (int i = 1; i < index; i++) {
            if (selected[i] && banned[i][index]) {
                return; // 금지된 조합이므로 더 진행하지 않음
            }
        }

        selected[index] = true;
        backtracking(index + 1, selected);
        selected[index] = false;
    }
}