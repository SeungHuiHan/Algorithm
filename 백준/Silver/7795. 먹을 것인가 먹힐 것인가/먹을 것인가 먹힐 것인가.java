import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            int N=sc.nextInt();
            int M=sc.nextInt();

            int[] A=new int[N];
            int[] B=new int[M];

            for(int j=0;j<N;j++){
                A[j]=sc.nextInt();
            }

            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            for(int j=0;j<M;j++){
                B[j]=sc.nextInt();
                min=Math.min(min,B[j]);
                max=Math.max(max,B[j]);
            }

            Arrays.sort(B);
            int count=0;
            for(int j=0;j<N;j++){
                int a=A[j];


                int left=0;
                int right=M-1;
                int answer=0;
                while(left<=right){
                    int mid=(left+right)/2;

                    if(B[mid]<a){
                        answer=mid+1;
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }

                }
                count+=answer;
            }

            sb.append(count).append("\n");


        }

        System.out.println(sb);

        
    }

    
}