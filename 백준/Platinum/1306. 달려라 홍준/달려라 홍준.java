import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);

            // 윈도우 범위 바깥으로 나간 값 제거
            int windowStart = i - (2 * M - 2); // 왼쪽 끝 인덱스
            if (!dq.isEmpty() && dq.peekFirst() < windowStart) {
                dq.pollFirst();
            }

            // 중심 인덱스가 M-1 이상일 때 출력
            if (i >= 2 * M - 2) {
                sb.append(arr[dq.peekFirst()]).append(" ");
            }
        }

        System.out.println(sb);
    }
}