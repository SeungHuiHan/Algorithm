import java.util.*;

public class Main{
    private static int N,K;
    private static boolean[] visited;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        
        visited=new boolean[100001];
        int answer=bfs(N,0);
        
        System.out.println(answer);
        
    }
    
    private static int bfs(int x,int count){
        ArrayDeque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{x,0});
        //visited[x]=true;
        
        while(!dq.isEmpty()){
            int[] current=dq.poll();
            int c=current[0];
            int cc=current[1];
            if(c==K){
                return cc;
            }
            
            
            int n1=c+1;
            if(n1>=0 && n1<100001 && !visited[n1]){
                visited[n1]=true;
                dq.add(new int[]{n1,cc+1});
            }
            
            int n2=c-1;
            if(n2>=0 && n2<100001 && !visited[n2]){
                visited[n2]=true;
                dq.add(new int[]{n2,cc+1});
            }
            
            int n3=2*c;
            if(n3>=0 && n3<100001 && !visited[n3]){
                visited[n3]=true;
                dq.add(new int[]{n3,cc+1});
            }
            
        }
        
        return 0;
    }
}