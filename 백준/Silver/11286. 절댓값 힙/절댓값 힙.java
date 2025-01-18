import java.util.*;

public class Main{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->{
            if(Math.abs(a)==Math.abs(b)) return Integer.compare(a,b);
            return Integer.compare(Math.abs(a),Math.abs(b));
        });

        StringBuilder sb=new StringBuilder();

        int N=sc.nextInt();

        for(int i=0;i<N;i++){
            int n=sc.nextInt();

            if(pq.isEmpty() && n==0){
                sb.append(0).append("\n");
            }else if(n==0) {
                sb.append(pq.poll()).append("\n");
            }else{
                pq.add(n);

            }

        }
        System.out.println(sb);
        
    }
}