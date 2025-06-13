import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int D=sc.nextInt();
        //0-정보과학관
        //1-전산관, 2-미래관, 3-신양관, 4-진리관, 5- 한경직기념관, 6-학생회관, 7- 형남공학관
        List<Integer>[] graph=new ArrayList[8];

        for(int i=0;i<8;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(1); graph[0].add(2);
        graph[1].add(0); graph[1].add(2); graph[1].add(3);
        graph[2].add(0); graph[2].add(1); graph[2].add(3); graph[2].add(5);
        graph[3].add(1); graph[3].add(2); graph[3].add(4); graph[3].add(5);
        graph[4].add(3); graph[4].add(5); graph[4].add(6);
        graph[5].add(2); graph[5].add(3); graph[5].add(4); graph[5].add(7);
        graph[6].add(4); graph[6].add(7);
        graph[7].add(5); graph[7].add(6);



        long[][] dp=new long[D+1][8];
        dp[0][0]=1;

        for(int i=1;i<=D;i++){
            for(int j=0;j<8;j++){
                for(int map:graph[j]){
                    dp[i][j]=(dp[i][j]+dp[i-1][map])%1000000007;
                }
            }
        }


        System.out.println(dp[D][0]);
    }
}