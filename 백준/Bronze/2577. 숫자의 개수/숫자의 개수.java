import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        
        long d=a*b*c;
        int[] arr=new int[10];
      
        while(d>0){
            int n=(int)d%10;
            arr[n]++;
            
            d/=10;
        }
        
        for(int i=0;i<=9;i++)
            System.out.println(arr[i]);
    }
}