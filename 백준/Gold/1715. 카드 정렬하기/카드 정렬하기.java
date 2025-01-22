import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            pq.add(n);
        }

        int sum=pq.poll();
        int total=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
            total+=sum;
            pq.add(sum);
            sum=pq.poll();
        }
       // total+=sum;
        System.out.println(total);

    }
}