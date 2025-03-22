import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        ArrayDeque<Integer> deque=new ArrayDeque<>();

        int N=sc.nextInt();

        for(int i=1;i<=N;i++){
            deque.addLast(i);
        }

        while(deque.size()>1){
            deque.pollFirst(); // 1. 맨 위 카드 버림
            int temp = deque.pollFirst(); // 2. 맨 위 카드 꺼냄
            deque.addLast(temp); // 3. 꺼낸 카드 맨 뒤로 보냄
        }

        System.out.println(deque.peek());
    }
}