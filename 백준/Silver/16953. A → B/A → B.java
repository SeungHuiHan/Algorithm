import java.util.*;

public class Main{
    private static ArrayDeque<long[]> queue;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int A=sc.nextInt();
        int B=sc.nextInt();

        queue=new ArrayDeque<>();

        System.out.println(bfs(A,B));
    }

    private static long bfs(int start,int target){
        queue.add(new long[]{start,1});

        while(!queue.isEmpty()){
            long[] current=queue.poll();
            long a=current[0];
            long b=current[1];

            if(a==target) {
                return b;
            }

            if(a*2<=target){
                queue.add(new long[]{a*2,b+1});
            }

            if((a*10+1)<=target){
                queue.add(new long[]{a*10+1,b+1});
            }

        }

        return -1;
    }
}