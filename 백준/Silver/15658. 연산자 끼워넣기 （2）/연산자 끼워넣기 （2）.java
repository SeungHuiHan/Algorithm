import java.util.Scanner;

public class Main{
    private static int N;
    private static int[] A;
    private static int[] operations=new int[4];
    private static int maxN=Integer.MIN_VALUE;
    private static int minN=Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        A=new int[N];

        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        for(int i=0;i<4;i++){
            operations[i]=sc.nextInt();
        }

        backtracking(A[0],1);
        System.out.println(maxN);
        System.out.println(minN);

    }

    private static void backtracking(int sum,int index){
        if(index==N){
            maxN=Math.max(maxN,sum);
            minN=Math.min(minN,sum);
            return;
        }

        for(int i=0;i<4;i++){
            if(operations[i]>0){
                operations[i]--;
                int nextSum=Calcultation(sum,i,index);
                backtracking(nextSum,index+1);
                operations[i]++;
            }
        }
    }


    private static int Calcultation(int a,int op,int b){
        if(op==0)
            return a+A[b];
        else if(op==1)
            return a-A[b];
        else if(op==2)
            return a*A[b];
        else if(op==3)
            return a/A[b];
        return 0;
    }
}