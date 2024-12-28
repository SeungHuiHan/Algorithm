import java.util.*;

public class Main{
    private static ArrayList<Integer>[] asList;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int M=sc.nextInt();
        int N=sc.nextInt();

        visited=new boolean[M+1];

        asList=new ArrayList[M+1];
        for(int i=0;i<=M;i++)
            asList[i]=new ArrayList<>();

        for(int i=0;i<N;i++){
            int p1=sc.nextInt();
            int p2=sc.nextInt();

            asList[p1].add(p2);
            asList[p2].add(p1);
        }

        for(int i=1;i<=M;i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }


    private static void dfs(int now){
        visited[now]=true;

        for(int next:asList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}