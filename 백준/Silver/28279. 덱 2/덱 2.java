import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deque<Integer> deq = new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();


            if (a == 1) {
                int b = sc.nextInt();
                deq.addFirst(b);
            } else if (a == 2) {
                int b = sc.nextInt();
                deq.addLast(b);
            } else if (a == 3) {
                if (deq.size() > 0) sb.append(deq.removeFirst()).append("\n");
                else sb.append(-1).append("\n");
            } else if (a == 4) {
                if (deq.size() > 0) sb.append(deq.removeLast()).append("\n");
                else sb.append(-1).append("\n");
            } else if (a == 5) {
                sb.append(deq.size()).append("\n");
            } else if (a == 6) {
                if (deq.size() != 0) sb.append(0).append("\n");
                else sb.append(1).append("\n");
            } else if (a == 7) {
                if (deq.size() > 0) sb.append(deq.getFirst()).append("\n");
                else sb.append(-1).append("\n");
            } else if (a == 8) {
                if (deq.size() > 0) sb.append(deq.getLast()).append("\n");
                else sb.append(-1).append("\n");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}