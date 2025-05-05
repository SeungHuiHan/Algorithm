import java.util.*;

public class Main{
    private static int N,M,L;
    private static int[] points;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        L=sc.nextInt();

        points = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            points[i] = sc.nextInt();  // 휴게소 위치
        }
        points[0] = 0;
        points[N + 1] = L;
        Arrays.sort(points);


        int left=1;
        int right=L-1;
        int  temp=0;
        while(left<=right){
            int mid=(left+right)/2;

            if(canCut(mid)){ //최대의 최소값 구하기
                temp=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        int maxLength=0;
        for(int i=1;i<points.length;i++){
            int dist=points[i]-points[i-1];
            if(dist<temp) maxLength=Math.max(maxLength,points[i]-points[i-1]);
            else{
                int count=(dist-1)/temp;
                maxLength=Math.max(maxLength,Math.max(temp,dist-(count*temp)));
            }
        }
        System.out.println(maxLength);


    }

    private static boolean canCut(int mid){
        int count=0;
        for(int i=1;i<points.length;i++){
            int dist=points[i]-points[i-1];
            if(dist>=mid)
                count+=(dist-1)/mid;

        }

        return count<=M;
    }
}