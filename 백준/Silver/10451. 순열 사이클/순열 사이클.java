import java.io.*;
import java.util.*;


public class Main {
    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            int N=Integer.parseInt(bf.readLine());
            adList=new ArrayList[N+1];
            visited=new boolean[N+1];
            for(int i=1;i<=N;i++){
                adList[i]=new ArrayList<>();
            }
            StringTokenizer st=new StringTokenizer(bf.readLine());
            for(int i=1;i<=N;i++){
                int a=Integer.parseInt(st.nextToken());
                adList[a].add(i);
            }


            count=0;
            for(int i=1;i<=N;i++){
                if(!visited[i]){
                    dfs(i);
                    count++;
                }


            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int now){
        visited[now]=true;

        for(int next:adList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
        
    }
}
