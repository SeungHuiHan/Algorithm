import java.util.*;
import java.io.*;

public class Main{
    private static int S,C;
    private static int[] vegetables;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        S=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        vegetables=new int[S];
        int max=0;
        long total=0;
        for(int i=0;i<S;i++){
            vegetables[i]=Integer.parseInt(bf.readLine());
            max=Math.max(max,vegetables[i]);
            total+=vegetables[i];
        }


        long length=0;
        long left=1;
        long right=max;

        while(left<=right){
            long mid=(left+right)/2;

            if(canCut(mid)){
                length=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        System.out.println(total-C*length);

    }

    private static boolean canCut(long mid){
        long count=0;

        for(int veg:vegetables){
            count+=veg/mid;
        }

        return count>=C;
    }
}