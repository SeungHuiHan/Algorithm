import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();

        int[][] paper=new int[N][M];

        for(int i=0;i<N;i++){
            String input=sc.nextLine();
            for(int j=0;j<M;j++){
                paper[i][j]=input.charAt(j)-'0';
            }
        }

        int maxSum=0;

        //세로 1 가로 0
        for(int mask=0;mask<(1<<(N*M));mask++){
            int sum=0;

            //가로
            for(int i=0;i<N;i++){
                int current=0;
                for(int j=0;j<M;j++){
                    int bit = i * M + j; // 현재 칸의 비트 인덱스
                    if((mask&(1<<bit))==0){
                        current=10*current+paper[i][j];
                    }else{ //세로로 바뀌면 합산
                        sum+=current;
                        current=0;
                    }
                }

                sum+=current;
            }

            //세로
            for(int i=0;i<M;i++){
                int current=0;
                for(int j=0;j<N;j++){
                    int bit = j * M + i; // 현재 칸의 비트 인덱스
                    if((mask&(1<<bit))!=0){
                        current=10*current+paper[j][i];
                    }else{ //가로로 바뀌면 합산
                        sum+=current;
                        current=0;
                    }
                }

                sum+=current;
            }

            //최대값
            maxSum=Math.max(maxSum,sum);
        }


        System.out.println(maxSum);
    }
}