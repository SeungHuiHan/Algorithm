import java.util.*;

public class Main{
    private static int N;
    private static StringBuilder sb=new StringBuilder();
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();

        backtracking(2,1);
        backtracking(3,1);
        backtracking(5,1);
        backtracking(7,1);

        System.out.println(sb);

    }

    private static void backtracking(int current,int count){
        if(count==N){
            if(isPrime(current)){
                sb.append(current).append("\n");
            }
            return;
        }

        for(int i=0;i<=9;i++){
            int next=current*10+i;
            if(isPrime(next)){
                backtracking(next,count+1);
            }
        }

    }

    private static boolean isPrime(int n){
        if(n<2) return false; //n이 0,1이면 소수 아님
        if(n==2) return true; //n이 2이면 소수
        if(n%2==0) return false; // n짝수일때


        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0) return false; //나누어떨어지면 소수 아님
        }
        return true; //끝까지 안떨어지면 소수
    }
}