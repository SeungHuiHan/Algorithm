import java.util.*;

public class Main{
    private static int[ ] arr;
    private static StringBuilder sb;
    private static int[] numbers;
    private static int N,M;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sb=new StringBuilder();

        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();
        arr=new int[N];
        numbers=new int[M];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        backtracking(0,0);

        System.out.println(sb.toString());

    }

    private static void backtracking(int start, int count){
        if(count==M){
            for(int n:numbers)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }


        for(int i=start;i<N;i++){
            numbers[count]=arr[i];
            backtracking(i,count+1);
        }
    }
}