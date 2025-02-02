import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int[][] weights=new int[N+1][N+1];
        final int INF=100000;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                weights[i][j]=INF;
                if(i==j) weights[i][j]=0;
            }

        }

        while(true){
            int f1=sc.nextInt();
            int f2=sc.nextInt();

            if(f1==-1 && f2==-1) break;

            weights[f1][f2]=1;
            weights[f2][f1]=1;
        }

        
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    weights[i][j]=Math.min(weights[i][j],weights[i][k]+weights[k][j]);
                }
            }
        }


        int[] score = new int[N+1];
        for(int i=1; i<=N; i++){
            int maxDist = 0;
            for(int j=1; j<=N; j++){
                if(weights[i][j] != INF) {
                    maxDist = Math.max(maxDist, weights[i][j]);
                }
            }
            score[i] = maxDist; // 가장 멀리 있는 사람까지의 거리 (회장 점수)
        }

        List<Integer> candidate=new ArrayList<>();
        int minscore = Integer.MAX_VALUE;
        
        for(int i=1; i<=N; i++){
            if(score[i] != INF) {  // INF 값 제외
                minscore = Math.min(minscore, score[i]);
            }
        }

        for(int i=1;i<=N;i++){
            if(score[i]==minscore) candidate.add(i);
        }
        Collections.sort(candidate);

        System.out.println(minscore+" "+ candidate.size());
        for(int i:candidate) System.out.print(i+" ");
    }
}