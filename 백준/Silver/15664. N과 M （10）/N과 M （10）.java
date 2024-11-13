import java.util.*;

public class Main{
    private static int[] arr;
    private static int[] numbers;
    private static StringBuilder sb;
    private static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        numbers = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 사전 순 출력을 위해 정렬
        backtracking(0, 0);

        System.out.print(sb.toString());
    }

    private static void backtracking(int start, int count) {
        if (count == M) {
            for (int n : numbers)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        int pre = -1; // 중복 확인 변수
        for (int i = start; i < N; i++) {
            if (arr[i] == pre) continue; 
            pre = arr[i]; 

            numbers[count] = arr[i]; 
            backtracking(i + 1, count + 1); 
        }
    }
}