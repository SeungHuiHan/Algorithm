import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            long n=sc.nextLong();


            long result=0;
            long powerOfThree=1;

            while(n>0){
                if((n&1)==1){
                    result+=powerOfThree;
                }
                powerOfThree*=3;
                n>>=1;
            }
            System.out.println(result);
        }
    }
}