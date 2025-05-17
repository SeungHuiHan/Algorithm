import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        if(N==1){
            System.out.println(1);
            return;
        }
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
        }

        int[] increaseDp=new int[N+1];
        int[] decreaseDp=new int[N+1];
        Arrays.fill(increaseDp,1);
        Arrays.fill(decreaseDp,1);

        for(int i=2;i<=N;i++){
            if(arr[i]>=arr[i-1]){
                increaseDp[i]=increaseDp[i-1]+1;
            }

            if(arr[i]<=arr[i-1]){
                decreaseDp[i]=decreaseDp[i-1]+1;
            }
//            for(int j=1;j<i;j++){
//                if(arr[j]<=arr[i]){
//                    increaseDp[i]=Math.max(increaseDp[i],increaseDp[j]+1);
//                }
//
//                if(arr[j]>=arr[i]){
//                    decreaseDp[i]=Math.max(decreaseDp[i],decreaseDp[j]+1);
//                }
//            }
        }


        int maxLength=Integer.MIN_VALUE;

        for(int i=1;i<=N;i++){
            maxLength=Math.max(maxLength,Math.max(increaseDp[i],decreaseDp[i]));
        }

        System.out.println(maxLength);



    }
}