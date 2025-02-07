import java.util.*;

public class Main{
    private static int sum;
    private static ArrayList<Integer> list=new ArrayList<>();
    private static int N;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();

        for(int i=0;i<N;i++){
            int a=sc.nextInt();
            list.add(a);
        }
        backtracking(0,0);

        System.out.println(sum);
    }

    private static void backtracking(int count,int currentSum){
        if(count==N-2){
            sum=Math.max(sum,currentSum);
            return;
        }

        for(int i=1;i<list.size()-1;i++){
            currentSum+=list.get(i-1)*list.get(i+1);
            int n=list.get(i);
            list.remove(i);
            
            backtracking(count+1,currentSum);
            list.add(i,n);
            currentSum-=list.get(i-1)*list.get(i+1);
        }
    }
}