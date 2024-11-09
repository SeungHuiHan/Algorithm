import java.util.*;

public class Main{
    private static  int N;
    private static  int M;
    private static  int[] numbers;
    private static  int[] expression;
    private static  boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        expression=new int[N];
        numbers=new int[M];
        visited=new boolean[N];
        sc.nextLine();
        sb=new StringBuilder();

        String[] input=sc.nextLine().split(" ");
        for(int i=0;i<N;i++){
            expression[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(expression);

        backtracking(0);

        System.out.println(sb.toString());
    }

    private static void backtracking(int count){
        if(count==M){
            for(int n:numbers)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }


        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                numbers[count]=expression[i];
                backtracking(count+1);
                visited[i]=false;

            }

        }

    }
}