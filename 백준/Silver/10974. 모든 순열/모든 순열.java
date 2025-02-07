import java.util.*;


public class Main{
    private static int N;
    private static StringBuilder sb=new StringBuilder();
    private static boolean[] visited;
    private static int[] arr;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        visited=new boolean[N+1];
        arr=new int[N+1];

        backtracking(1,0);

        System.out.println(sb);

    }

    private static void backtracking(int index,int count){
        if(count==N){
            for(int i=1;i<=N;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i]=true;
                arr[index]=i;
                backtracking(index+1,count+1);
                visited[i]=false;
            }
        }
    }
}