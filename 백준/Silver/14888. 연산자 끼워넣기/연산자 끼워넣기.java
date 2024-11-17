import java.util.*;

public class Main{
    private static ArrayList<Integer> sums=new ArrayList<>();
    private static int N;
    private static int[] numbers;
    private static int[] operation=new int[4];
    private static int maxSum=Integer.MIN_VALUE;
    private static int minSum=Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        sc.nextLine();
        
        numbers=new int[N];
        for(int i=0;i<N;i++){
            numbers[i]=sc.nextInt();
        }
        sc.nextLine();
        for(int i=0;i<4;i++){
            operation[i]=sc.nextInt();
        }

        backtracking(numbers[0],1);
        System.out.println(maxSum);
        System.out.println(minSum);
    }

    private static void backtracking(int sum,int index){
        if(index==N){
            minSum=Math.min(minSum,sum);
            maxSum=Math.max(maxSum,sum);
            return;
        }

        for(int i=0;i<4;i++){
            if(operation[i]>0){
                operation[i]--;
                int nextSum=calculate(sum,i,numbers[index]);
                backtracking(nextSum,index+1);
                operation[i]++;
            }
        }

    }

    private static int calculate(int a,int index,int b){
        int sum=0;
        if(index==0) sum=a+b;
        else if(index==1) sum=a-b;
        else if(index==2) sum=a*b;
        else if(index==3) sum=a/b;
        return sum;
    }
}