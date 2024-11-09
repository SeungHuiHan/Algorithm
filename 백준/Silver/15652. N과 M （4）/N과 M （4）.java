import java.util.*;

public class Main{
    private static int N;
    private static int M;
    private static StringBuilder sb;
    private static int[] numbers;

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

        int start=(count==0)?1:numbers[count-1];

        for(int i=start;i<=N;i++){
            numbers[count]=i;
            backtracking(count+1);
        }

    }
}