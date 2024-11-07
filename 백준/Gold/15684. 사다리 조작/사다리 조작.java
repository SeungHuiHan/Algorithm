import java.util.*;

public class Main{
    private static boolean[][] visited;
    private static int N,M,H;
    private static int minCount=Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        H=sc.nextInt();
        sc.nextLine();
        visited=new boolean[H+1][N+1];

        for(int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            visited[a][b]=true;
        }

        for(int i=0;i<=3;i++){
            if(ladderBacktracking(i,0)){
                minCount=i;
                break;
            }
        }

        minCount=(minCount>3)?-1:minCount;
        System.out.println(minCount);
    }

    //가로선 추가
    private static boolean ladderBacktracking(int target,int count){
        if(count==target){
            return checkLadders();
        }

        //가로선 추가 탐색
        for(int i=1;i<=H;i++){
            for(int j=1;j<N;j++){
                //가로선이 연속하거나 인접한 가로선이 없도록 확인
                if(!visited[i][j] && !visited[i][j-1] && !visited[i][j+1]){
                    visited[i][j]=true;
                    if(ladderBacktracking(target,count+1)){
                        return true;
                    }
                    visited[i][j]=false;
                }
            }
        }

        return false;
    }

    //사다리 결과
    private static boolean checkLadders(){
        //i번 세로선 시작해서 i번으로 도착하는지 확인
        for(int i=1;i<=N;i++){ //세로선 1부터 N개!! 확인하기
            int position=i; //현재 세로선 위치 (행)
            for(int j=1;j<=H;j++){ //가로선 위치 (열)
                if(visited[j][position] && position<N)
                    position++;
                else if(visited[j][position-1] && position>1)
                    position--;
            }

            if(position!=i)
                return false; //자기자리로 못돌아올때
        }
        return true; //모든선이 자기 자리로 돌아옴
    }

}