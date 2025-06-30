import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        StringBuilder sb=new StringBuilder();
        
        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int N=sc.nextInt();
            int M=sc.nextInt();
            int[][] arr=new int[M][2];
            for(int j=0;j<M;j++){
                arr[j][0]=sc.nextInt();
                arr[j][1]=sc.nextInt();
            }
            sb.append(N-1).append("\n");
        }
        
        System.out.println(sb);
    }
}