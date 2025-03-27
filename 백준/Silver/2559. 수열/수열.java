import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();

        int start=0;
        int maxTemp=Integer.MIN_VALUE;

        int[] temp=new int[N];
        for(int i=0;i<N;i++){
            temp[i]=sc.nextInt();
        }

        int total=0;
        for(int end=0;end<N;end++){
            total+=temp[end];

            while(end-start+1>K){
                total-=temp[start];
                start++;
            }

            if(end-start+1==K){
                maxTemp=Math.max(maxTemp,total);
            }


        }

        System.out.println(maxTemp);
    }
}