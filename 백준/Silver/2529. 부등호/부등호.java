import java.util.*;

public class Main{
   private static int N;
    private static char[] signs;
    private static boolean[] visited=new boolean[10];
    private static String maxResult="";
    private static String minResult="";

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=Integer.parseInt(sc.nextLine());
        signs=new char[N];

        String[] input=sc.nextLine().split(" ");
        for(int i=0;i<N;i++){
            signs[i]=input[i].charAt(0);
        }

        //최대값
        backtrackingMax(0,"");

        Arrays.fill(visited,false); //visited초기화

        //최소값
        backtrackingMin(0,"");

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    //최대값 구하기
    private static void backtrackingMax(int count,String current){
        if(count==N+1){
            if(maxResult.isEmpty()||Long.parseLong(maxResult)<Long.parseLong(current)){ //maxResult가 초기화된 상태거나 현재 값이 더 클때
                maxResult=current;
            }
            return;
        }

        for(int i=9;i>=0;i--){
            if(!visited[i]){
                if(count==0 ||compare(current.charAt(count-1)-'0',signs[count-1],i)){
                    visited[i]=true;
                    backtrackingMax(count+1,current+i);
                    visited[i]=false;
                }
            }
        }
    }

    private static void backtrackingMin(int count,String current){
        if(count==N+1){
            if( minResult.isEmpty()||Long.parseLong(minResult)>Long.parseLong(current)){ //minResult가 초기화된 상태거나 현재 값이 더 작을때
                minResult=current;
            }
           return;
        }

        for(int i=0;i<=9;i++){
            if(!visited[i]){
                if(count==0 || compare(current.charAt(count-1)-'0',signs[count-1],i)){
                    visited[i]=true;
                    backtrackingMin(count+1,current+i);
                    visited[i]=false;
                }
            }
        }
    }

    private static boolean compare(int a,char sign,int b){
        if(sign=='<') return a<b;
        else return a>b;
    }
}