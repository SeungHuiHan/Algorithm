import java.util.*;

public class Main{
    private static int N,M;
    private static int[] lights;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();

        lights=new int[M];
        for(int i=0;i<M;i++){
            lights[i]=sc.nextInt();
        }

        int left=0;
        int right=N;
        int answer=0;

        while(left<=right){
            int mid=(left+right)/2;

            if(canOver(mid)){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        System.out.println(answer);
    }

    private static boolean canOver(int mid){
        int reach=0;
        
        for(int i=0;i<lights.length;i++){
            int left=lights[i]-mid;
            int right=lights[i]+mid;


            if(left>reach) return false;
            
            reach=Math.max(reach,right); //덮인 그림자 오른쪽 길이 갱신
            
        }

        

        return reach>=N;
    }
}