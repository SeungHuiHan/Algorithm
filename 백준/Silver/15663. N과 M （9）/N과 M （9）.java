import java.util.*;

public class Main{
    private static int[] arr;
    private static int[] numbers;
    private static boolean[] visited;
    private static int N,M;
    private static StringBuilder sb;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sb=new StringBuilder();

        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();
        arr=new int[N];
        visited=new boolean[N];
        numbers=new int[M];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        backtracking(0);
        System.out.println(sb.toString());

    }

    private static void backtracking(int count){
        if(count==M){
            for(int n:numbers){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        int tmp=-1;
        for(int i=0;i<N;i++){
            if(!visited[i]&& tmp!=arr[i]){
                tmp=arr[i];
                visited[i]=true;
                numbers[count]=arr[i];
                backtracking(count+1);
                visited[i]=false;
            }
        }
    }
}