import java.util.*;

public class Main{
    private static int N,C;
    private static int[] homes;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        C=sc.nextInt();

        homes=new int[N];
        for(int i=0;i<N;i++){
            homes[i]=sc.nextInt();
        }

        Arrays.sort(homes);

        int left=1;
        int right=homes[N-1]-homes[0];
        int answer=0; //공유기 가장 인접한 거리의 최대값

        while(left<=right){
            int mid=(left+right)/2;

            if(canPlace(mid,homes)){
                answer=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        System.out.println(answer);
    }

    private static boolean canPlace(int mid,int[] homes){
        int count=1; //homes[0]에 하나 설치
        int lastHome=homes[0];

        for(int i=1;i<homes.length;i++){
            if(homes[i]-lastHome>=mid){ //mid 는 가장 인접한 공유기 거리의 최대값
                count++;
                lastHome=homes[i];
            }
        }

        return count>=C;
    }
}