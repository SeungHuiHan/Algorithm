import java.util.*;

public class Main{
    private static int N;
    private static int M;
    private static int[] numbers;
    private static StringBuilder sb;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        numbers=new int[M];
        sb=new StringBuilder();
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

        for(int i=1;i<=N;i++){
            numbers[count]=i;
            backtracking(count+1);

        }
    }
}