import java.util.*;

public class Main {
    private static int N,M;
    private static int minValue=Integer.MAX_VALUE;
    private static int[][] maps;
    private static int[] numbers1;
    private static int[] numbers2;
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        sc.nextLine();
        M=N/2;
        maps=new int[N][N];
        numbers1=new int[M];
        numbers2=new int[M];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            String[] input=sc.nextLine().split(" ");
            for(int j=0;j<N;j++){
                maps[i][j]=Integer.parseInt(input[j]);
            }
        }
        backtracking(0,0);
        System.out.println(minValue);
    }

    private static void backtracking(int start,int count){
        if(count==M){
            int index=0;
            for(int i=0;i<N;i++){
                if(!visited[i]){
                    numbers2[index++]=i;
                }
            }

            int stark=calculate(numbers1);
            int link=calculate(numbers2);
            int value=Math.abs(stark-link);
            minValue=Math.min(minValue,value);
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                numbers1[count]=i;
                visited[i]=true;
                backtracking(i+1,count+1);
                visited[i]=false;
            }

        }
    }


    private static int calculate(int[] team){
        int sum=0;
        for(int i=0;i<M-1;i++){
            for(int j=i+1;j<M;j++){
                sum+=maps[team[i]][team[j]]+maps[team[j]][team[i]];
            }
        }
        return sum;
    }


}
