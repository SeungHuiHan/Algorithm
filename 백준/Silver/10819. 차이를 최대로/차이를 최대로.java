import java.util.*;

public class Main{
    private static ArrayList<Integer> numbers=new ArrayList<>();
    private static boolean[] visited;
    private static int[] arr;
    private static int N;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        arr=new int[N];
        visited=new boolean[N];


        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        // 모든 원소가 시작점이 될 수 있다
        for(int i=0;i<N;i++){
            visited[i]=true;
            backtracking(i,0,1);
            visited[i]=false;
        }
        Collections.sort(numbers,Collections.reverseOrder());

        System.out.println(numbers.get(0));
    }

    private static void backtracking(int index,int sum,int count){
        if(count==N){
            numbers.add(sum);
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                backtracking(i,sum+Math.abs(arr[index]-arr[i]),count+1);
                visited[i]=false;
            }
        }
    }
}