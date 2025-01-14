import java.util.*;

public class Main{
    private static int N;
    private static ArrayList<Long> list=new ArrayList<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();

        if(N>1022){
            System.out.println(-1);
            return;
        }

        for(int i=1;i<=10;i++){
            backtracking(9,0,0,i);
        }

        Collections.sort(list);

        System.out.println(list.get(N));
        
    }

    private static void backtracking(int start,long current,int count,int target){
        if(count==target){
            list.add(current);
            return;
        }

        for(int i=start;i>=0;i--){
            backtracking(i-1,current*10+i,count+1,target);
        }
        
    }
}