import java.util.*;

public class Main{
    private static int[][] maps;
    private static boolean[] visited;
    private static int maxPower;

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        for(int i=0;i<T;i++){
            maps=new int[11][11];
            visited=new boolean[11];
            maxPower=0;

            for(int j=0;j<11;j++){
                for(int k=0;k<11;k++){
                    maps[j][k]=sc.nextInt();
                }
            }

            backtracking(0,0);
            System.out.println(maxPower);
        }

    }

    private static void backtracking(int power,int count){
        if(count==11){
            maxPower=Math.max(maxPower,power);
            return;
        }

        for(int j=0;j<11;j++){

            if( maps[count][j]!=0 && !visited[j]){
                visited[j]=true;
                backtracking(power+maps[count][j],count+1);
                visited[j]=false;
            }

        }

    }
}