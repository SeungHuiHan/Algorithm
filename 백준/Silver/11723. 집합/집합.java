import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int M=Integer.parseInt(bf.readLine());

        int S=0;
        for(int i=0;i<M;i++){
            String[] st=bf.readLine().split(" ");
            String op=st[0];

            if(op.equals("add")){
                int n=Integer.parseInt(st[1]);
                S |=(1<<(n-1)); // S에 x를 추가, 이미 있는 경우 무시
                
            }else if(op.equals("remove")){
                int n=Integer.parseInt(st[1]);
                S &=~(1<<(n-1)); // S에서 x를 제거, 이미 없는 경우 무시
                
            }else if(op.equals("check")){
                int n=Integer.parseInt(st[1]);
                sb.append((S &(1<<(n-1)))!=0?1:0).append("\n"); // S에 x가 있으면 1을, 없으면 0을 출력
                
            }else if(op.equals("toggle")){
                int n=Integer.parseInt(st[1]);
                S^=(1<<(n-1)); //x가 있으면 x를 제거하고, 없으면 x를 추가
                
            }else if(op.equals("all")){
                S=(1<<20)-1;  //{1, 2, ..., 20} 으로 바꿈
            }else{
                S=0; //공집합
            }
        }

        System.out.println(sb);
    }
}