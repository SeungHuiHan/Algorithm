import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        
        for(int j=0;j<T;j++){
            int N=sc.nextInt();
            int[] note1=new int[N];
            
            for(int i=0;i<N;i++){
                note1[i]=sc.nextInt();
            }
            
            Arrays.sort(note1);


            int M=sc.nextInt();
            int[] note2=new int[M];
            for(int i=0;i<M;i++){
                note2[i]=sc.nextInt();
            }

            
            for(int i=0;i<M;i++){
                int n=note2[i];
                int left=0;
                int right=N-1;
                int answer=0;

                while(left<=right){
                    int mid=(left+right)/2;

                    if(note1[mid]==n){
                        answer=1;
                        break;
                    }else if(note1[mid]>n){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }

                sb.append(answer).append("\n");

            }


            
        }
        System.out.println(sb);
        
    }
}