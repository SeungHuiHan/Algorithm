import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        long S=sc.nextLong();

        int i=1;
        int count=0;
        long sum=0;
        while(sum+i<=S){
            sum+=i;
            i++;
            count++;
        
        }

        System.out.println(count);
    }
}