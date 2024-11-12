import java.util.*;

public class Main{
    private static char[][] maps;
    private static boolean[][] visited;
   // private static ArrayList< visited;
    private static int R,C,K;
    //private static int[] start;
    //private static int[] end;
    private static int totalCount;
    private static int[] dx={-1,1,0,0};
    private static int[] dy={0,0,-1,1};



    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        R=sc.nextInt();
        C=sc.nextInt();
        K=sc.nextInt();
        sc.nextLine();

        maps=new char[R][C];
        visited=new boolean[R+1][C+1];

        for(int i=0;i<R;i++){
            String[] input=sc.nextLine().split("");
            for(int j=0;j<C;j++){
                maps[i][j]=input[j].charAt(0);
            }
        }

        //start=new int[]{R,0};
        //end=new int[]{0,C};

        backtracking(R-1,0,1);
        System.out.println(totalCount);

    }

    private static void backtracking(int cx,int cy,int count){
        visited[cx][cy]=true;
        if(count==K){
            if(cx==0 && cy==C-1){
                totalCount++;
                return;
            }else
                return;
        }



            for(int j=0;j<4;j++){
                int nx=cx+dx[j];
                int ny=cy+dy[j];

                if(nx>=0 && ny>=0 && nx<R && ny<C && maps[nx][ny]!='T'){
                    if(!visited[nx][ny]){
                        visited[nx][ny]=true;
                        backtracking(nx,ny,count+1);
                        visited[nx][ny]=false;
                    }

                }

            }

    }
}