import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;
    private static int[] order;
    private static int count;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());

        adList=new ArrayList[N+1];
        visited=new boolean[N+1];
        order=new int[N+1];

        for(int i=1;i<=N;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=1;i<=M;i++){
            st=new StringTokenizer(bf.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adList[u].add(v);
            adList[v].add(u);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adList[i]);
        }

        dfs(R);


        for(int i=1;i<=N;i++){
            sb.append(order[i]).append("\n");
        }


        System.out.println(sb);

    }

    private static void dfs(int now){
        visited[now]=true;
        order[now]=++count;

        for(int next:adList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }

    }
}
