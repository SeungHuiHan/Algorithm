import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        StringBuilder sb=new StringBuilder();
        
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            if(n==0){
                if(pq.isEmpty()){
                    sb.append("0").append("\n");
                }else{
                    int num=pq.poll();
                    sb.append(num).append("\n");
                }
            }else{
                pq.add(n);
            }
        }
        
        System.out.println(sb);
    }
}