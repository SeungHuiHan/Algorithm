import java.util.*;

public class Main{
    private static int N,H;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        H=sc.nextInt();
        int[] uppersticks=new int[N/2]; //종류석
        int[] lowersticks=new int[N/2]; //석순

        for(int i=0;i<N;i++){
            if(i%2==0)
                lowersticks[i/2]=sc.nextInt();
            else
                uppersticks[i/2]=sc.nextInt();
        }
        Arrays.sort(uppersticks);
        Arrays.sort(lowersticks);


        int min=Integer.MAX_VALUE;
        int count=0;
        for (int height = 1; height <= H; height++) {
            int bottom = lowersticks.length - lowerBound(lowersticks, height); // 석순: 높이 이상
            int top = uppersticks.length - lowerBound(uppersticks, H - height + 1); // 종유석: H - h 이하 제외

            int total = bottom + top;

            if (total < min) {
                min = total;
                count = 1;
            } else if (total == min) {
                count++;
            }
        }
        System.out.println(min+" "+count);

    }


    private static int lowerBound(int[] sticks, int target) {
        int left = 0;
        int right = N/2;

        while (left < right) {
            int mid = (left + right) / 2;

            if (sticks[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    
}