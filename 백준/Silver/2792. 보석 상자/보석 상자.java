import java.util.*;

public class Main{
    private static int N,M;
    private static int[] jewels;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();


        jewels=new int[M];
        int max=0;
        for(int i=0;i<M;i++){
            jewels[i]=sc.nextInt();
            max=Math.max(max,jewels[i]);
        }

        int left=1;
        int right=max;
        int answer=0;

        while(left<=right){
            int mid=(left+right)/2;

            if(canCut(mid)){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        System.out.println(answer);
    }

    private static boolean canCut(int mid){
        int count=0;

        for(int jewelry:jewels){
            if(jewelry<=mid ){
                count++;
            }else if(jewelry%mid==0){
                count+=jewelry/mid;
            }
            else{
                count+=(jewelry/mid+1);
            }

        }

        return count<=N;
    }
}