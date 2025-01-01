import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        sc.nextLine();
        int[][] triangle=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            String[] input = sc.nextLine().split(" ");

            for (int j =1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i=N-1;i>=1;i--){
            for(int j=1;j<=i;j++){
                triangle[i][j]+=Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        System.out.println(triangle[1][1]);
        
    }
}