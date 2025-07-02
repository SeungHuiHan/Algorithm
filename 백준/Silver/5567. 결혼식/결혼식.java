import java.util.*;
import java.io.*;

public class Main{
   private static List<Integer>[] adList;
    private static ArrayDeque<int[]> deque;
    static int count;

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        deque=new ArrayDeque<>();

        adList=new ArrayList[n+1];
        visited=new boolean[n+1];
        for(int i=0;i<=n;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();

            adList[a].add(b);
            adList[b].add(a);
        }

        bfs();
        System.out.println(count);

    }

    private static void bfs(){
        deque.add(new int[]{1,0});
        visited[1]=true;

        while(!deque.isEmpty()){
            int[] now=deque.poll();
            int n=now[0];
            int depth=now[1];

            if(depth==2) continue;

            for(int next:adList[n]){
                if(!visited[next]){
                    visited[next]=true;
                    count++;
                    deque.add(new int[]{next,depth+1});
                }
            }


        }
    }

}