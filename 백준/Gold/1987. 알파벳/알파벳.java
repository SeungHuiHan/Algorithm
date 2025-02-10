import java.util.*;
import java.io.*;

public class Main{
    private static char[][] maps;
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static HashSet<Character> set=new HashSet<>();
    private static int R,C,maxCount=0;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        R= Integer.parseInt(st.nextToken()); //열
        C= Integer.parseInt(st.nextToken()); //행

        maps=new char[R][C];

        for(int i=0;i<R;i++){
            String input=bf.readLine();
            for(int j=0;j<C;j++){
                maps[i][j]=input.charAt(j);
            }
        }

        set.add(maps[0][0]);
        dfs(0,0,1);

        System.out.println(maxCount);
    }

    private static void dfs(int x,int y,int count){
        maxCount=Math.max(maxCount,count);

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || ny<0 || nx>=R || ny>=C) continue;

            if(!set.contains(maps[nx][ny])){
                set.add(maps[nx][ny]);
                dfs(nx,ny,count+1);
                set.remove(maps[nx][ny]);
            }
            
        }

    }
}