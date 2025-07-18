import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<int[]>[] adList;
    private static boolean[] visited;
    private static long maxLength = 0;
    private static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(bf.readLine());
        adList=new ArrayList[N+1];

        for(int i=0;i<=N;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=1;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            adList[a].add(new int[]{b,c});
            adList[b].add(new int[]{a,c});
        }


        visited = new boolean[N + 1];
        maxLength = 0;
        dfs(1,0);

        System.out.println(maxLength);

    }

    private static void dfs(int now,long length){
        visited[now]=true;
        maxLength=Math.max(maxLength,length);

        for(int[] next:adList[now]){
            int node=next[0];
            int len=next[1];

            if(!visited[node]){
                dfs(node,length+len);
            }
        }

    }
}
