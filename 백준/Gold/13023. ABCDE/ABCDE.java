import java.io.*;
import java.util.*;


public class Main {
    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;
    private static int N,M;
    private static boolean found = false;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visited=new boolean[N];

        adList=new ArrayList[N];
        for(int i=0;i<N;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adList[a].add(b);
            adList[b].add(a);
        }

        for(int i=0;i<N;i++){
            dfs(i,1);
            if(found) break;
        }

        System.out.println(found?1:0);

    }

    private static void dfs(int now,int num){
        if(num==5) {
            found=true;
            return;
        }

        visited[now]=true;


        for(int next:adList[now]){
            if(!visited[next]){
                dfs(next,num+1);

            }
        }

        visited[now]=false;


    }
}
