import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] weights=new int[n+1][n+1];
        final int INF=500000;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                weights[i][j]=INF;
                if(i==j) weights[i][j]=0;
            }
        }

        for(int i=0;i<m;i++){
            int friends1=sc.nextInt();
            int friends2=sc.nextInt();
            weights[friends1][friends2]=1;
            weights[friends2][friends1]=1;
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    weights[i][j]=Math.min(weights[i][j],weights[i][k]+weights[k][j]);

                }
            }
        }

        int[] result=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                result[i]+=weights[i][j];
            }
        }

        int index=0;
        int totalweight=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(totalweight>result[i]){
                totalweight=result[i];
                index=i;
            }
        }

        System.out.println(index);

        
    }
}