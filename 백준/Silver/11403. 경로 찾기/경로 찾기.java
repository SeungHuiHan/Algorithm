import java.util.*;

public class Main{
    private static List<Integer>[] asList;
    //private static boolean[][] visited;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sb=new StringBuilder();

        int N=sc.nextInt();

        //visited=boolean[N][N];
        visited=new boolean[N];

        asList=new ArrayList[N];
        for(int i=0;i<N;i++)
            asList[i]=new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int p=sc.nextInt();
                if(p==1)
                    asList[i].add(j);
            }
        }

        for(int i=0;i<N;i++){
            Arrays.fill(visited,false);
            dfs(i);

            for(int j=0;j<N;j++){
                if(!visited[j])
                    sb.append("0");
                else
                    sb.append("1");
                sb.append(" ");
            }
            sb.append("\n");

        }

        System.out.println(sb.toString());

    }

    private static void dfs(int now){
        for(int next:asList[now]){
            if(!visited[next]){
                visited[next]=true;
                dfs(next);
            }
        }
    }
}