import java.util.*;

public class Main{
    private static int N,K;
    private static int[] arr;
    private static int answer;
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        K=sc.nextInt();
        arr=new int[N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        backtracking(0,500);
        System.out.println(answer);
    }

    private static void backtracking(int count,int sum){
        if(count==N){
            if(sum>=500){
                answer++;

            }
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]&&(sum+arr[i]-K)>=500){
                visited[i]=true;
                backtracking(count+1,sum+arr[i]-K);
                visited[i]=false;

            }

        }
    }
}