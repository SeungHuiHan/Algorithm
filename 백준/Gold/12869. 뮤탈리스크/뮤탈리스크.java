import java.util.*;

public class Main{
    
 private static int[] scv;
    
    private static ArrayDeque<int[]> queue;
    private static boolean[][][] visited;
    private static int minCount=Integer.MAX_VALUE;
    private static int[] mutalrisk=new int[]{9,3,1};
    

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        // SCV 개수 입력
        int N = sc.nextInt();

        // SCV 체력 입력
        scv = new int[3];
        visited = new boolean[61][61][61];
        queue=new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            scv[i] = sc.nextInt();
        }

        bsf(scv);
        System.out.println(minCount);
    }

    //count은 0또는 음수가 된 배열 개수
    private static void bsf(int[] scv){
        
        queue.add(new int[]{scv[0],scv[1],scv[2],0});
        
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int a = Math.max(current[0], 0);
            int b = Math.max(current[1], 0);
            int c = Math.max(current[2], 0);
            int count=current[3];
            
            if(a<=0 && b<=0 && c<=0){
                minCount=Math.min(minCount,count);
                return;
            }

       
        
        if(visited[a][b][c]) continue;
        visited[a][b][c] = true;

        queue.add(new int[]{current[0]-9,current[1]-3,current[2]-1,count+1});
        queue.add(new int[]{current[0]-9,current[1]-1,current[2]-3,count+1});
        queue.add(new int[]{current[0]-3,current[1]-9,current[2]-1,count+1});
        queue.add(new int[]{current[0]-3,current[1]-1,current[2]-9,count+1});
        queue.add(new int[]{current[0]-1,current[1]-9,current[2]-3,count+1});
        queue.add(new int[]{current[0]-1,current[1]-3,current[2]-9,count+1});

        }
        

    }
}