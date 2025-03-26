import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 풍선 번호, 이동 숫자 저장 (1번 풍선부터 n번까지)
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int move = sc.nextInt();
            deque.addLast(new int[]{i, move});
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            int[] current = deque.removeFirst(); // 풍선 터뜨리기
            sb.append(current[0]).append(" ");

            if (deque.isEmpty()) break;

            int move = current[1];

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }

        System.out.println(sb);
    }
}