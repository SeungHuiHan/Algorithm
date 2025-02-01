import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine()); //도시 개수
        int m=Integer.parseInt(br.readLine()); //버스의 개수
        int[][] maps=new int[n+1][n+1];
        final int INF=1000000000;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                maps[i][j]= INF;
                if(i==j) maps[i][j]=0;
            }
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());

            maps[start][end]=Math.min(maps[start][end],cost);
        }

        //플로이드-워셜
        for(int k=1;k<=n;k++){ //경유
            for(int i=1;i<=n;i++){ // 출발
                for(int j=1;j<=n;j++){ //도착
                    
                        maps[i][j]=Math.min(maps[i][k]+maps[k][j],maps[i][j]);
                    
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(maps[i][j]== INF ) sb.append(0).append(" ");
                else sb.append(maps[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}