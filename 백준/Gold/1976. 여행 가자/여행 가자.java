import java.util.*;
import java.io.*;

public class Main{
    static int[] parent;
    
    //find 연산- 경로 압축
    static int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    
    //union연산 - 병합
    static void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        
        if(rootX!=rootY){
            parent[rootY]=rootX;
        }
    }
   
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N=Integer.parseInt(bf.readLine());
        int M=Integer.parseInt(bf.readLine());
        
        //초기화 
        parent=new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i]=i;
        }
        
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<=N;j++){
                int connected= Integer.parseInt(st.nextToken());
                if(connected==1){ //도시 연결이 되어있다면
                    union(i,j);
                }
            }
        }
        
        //여행 계획
        int[] plan=new int[M];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<M;i++){
            plan[i]=Integer.parseInt(st.nextToken());
        }
        
        boolean possible=true;
        int root=find(plan[0]);
        for(int i=1;i<M;i++){
            if(find(plan[i])!=root){
                possible=false;
                break;
            }
        }
        
        System.out.println(possible?"YES":"NO");
        
    }
}