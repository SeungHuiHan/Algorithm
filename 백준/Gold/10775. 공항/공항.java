import java.util.*;
import java.io.*;

public class Main{
    public static int[] parent;

    public static int findParent(int x){
        if(parent[x]!=x){
            parent[x]=findParent(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int G=Integer.parseInt(br.readLine());
        int P=Integer.parseInt(br.readLine());

        //초기값
        parent=new int[G+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }

        int result=0;

        for(int i=0;i<P;i++){
            int gi=Integer.parseInt(br.readLine());

            //게이트 찾기
            int Gate=findParent(gi);

            if(Gate==0) break; //도킹할 공항 없으면 공항 폐쇄

            parent[Gate]=Gate-1; //도킹 후, 이 게이트는 사용못함. 하나씩 다운
            result++;
        }

        System.out.println(result);


    }
}