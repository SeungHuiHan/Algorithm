import java.util.*;

public class Main{
    private static int N;
    private static int M;
    private static boolean[] visited;
    private static int[] numbers;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        visited=new boolean[N+1];
        numbers=new int[M];

        backtracking(0);

    }

    private static void backtracking(int count){

        if(count==M){
            for(int n:numbers)
                System.out.print(n+" ");
            System.out.println();
            return;
        }
        
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i]=true;
                numbers[count]=i;
                backtracking(count+1);
                visited[i]=false;
            }
        }
        
    }
}