import java.util.*;
import java.io.*;

public class Main{
    static int[] parent;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        parent=new int[n];
        //초기화
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        int result=0;//사이클 완성된 번호
        
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            if(find(a)==find(b)){
                result=i; //사이클 완성
                break;
            }else{
                union(a,b); //사이클이 발생하지 않았다면 두 점을 연결
            }
        }
        
        System.out.println(result);
        
    }
    
    //find 연산- 경로 압축
    static int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]); //부모 루트를 갱신
        }
        return parent[x];
    }
    
    //union연산
    static void union(int x,int  y){
        int rootX=find(x);
        int rootY=find(y);
        
        if(rootX!=rootY){
            parent[rootY]=rootX; //한 쪽을 다른 쪽의 루트로 설정
         }
    }
}