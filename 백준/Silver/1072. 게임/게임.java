import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int X=sc.nextInt();
        int Y=sc.nextInt();
        int ratio=(int)((long)Y*100/X);

        int left=0;
        int right=1000000000;
        int answer=-1;

        while(left<=right){
            int mid=(left+right)/2;
            int newRatio=(int)((long)(Y+mid)*100/(X+mid));


            if(newRatio>ratio){
                answer=mid;
                right=mid-1;

            }else {
                left=mid+1;

            }

        }

        System.out.println(answer);
    }
}