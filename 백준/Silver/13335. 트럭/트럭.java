import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Queue<Integer> bridge=new ArrayDeque<>();


        int n=sc.nextInt();
        int w=sc.nextInt();
        int L=sc.nextInt();

        int[] trucks=new int[n];
        for(int i=0;i<n;i++){
            trucks[i]=sc.nextInt();
        }

        for(int i=0;i<w;i++){
            bridge.offer(0);
        }

        int totalWeight=0;
        int time=0;
        int index=0;
        
        //다리가 다 비워질때까지
        while(!bridge.isEmpty()){
            time++;

            totalWeight-=bridge.poll();

            //다리에 있는 트럭의 합이 L보다 작거나 같을때
            if(index<n && totalWeight+trucks[index]<=L){
                totalWeight+=trucks[index];
                bridge.offer(trucks[index]);
                index++;
            }else if(index<n){
                bridge.offer(0);
            }
        }


        System.out.println(time);
    }
}