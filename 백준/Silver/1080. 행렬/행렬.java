import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();

        int[][] A=new int[N][M];
        int[][] B=new int[N][M];

        for(int i=0;i<N;i++){
            String input=sc.nextLine();
            for(int j=0;j<M;j++){
                A[i][j]=input.charAt(j)-'0';
            }
        }
        for(int i=0;i<N;i++){
            String input=sc.nextLine();
            for(int j=0;j<M;j++){
                B[i][j]=input.charAt(j)-'0';
            }
        }

        if (N < 3 || M < 3) {
            if (equals(A,N,M,B)) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }
        

        int count=0;
        for(int i=0;i<=N-3;i++){
            for(int j=0;j<=M-3;j++){
                if(A[i][j]!=B[i][j]){
                    flip(A,i,j);
                    count++;
                }
            }
        }


        if(!equals(A,N,M,B)){
            System.out.println(-1);
        }else{
            System.out.println(count);
        }
    }

    private static void flip(int[][] A,int i,int j){
        for(int x=i;x<i+3;x++){
            for(int y=j;y<j+3;y++){
                A[x][y]=1-A[x][y];
            }
        }
    }

    private static boolean equals(int[][] A,int N,int M,int[][] B){
        for(int x=0;x<N;x++){
            for(int y=0;y<M;y++){
                if(A[x][y]!=B[x][y]){
                    return false;
                }
            }
        }

        return true;
    }

}