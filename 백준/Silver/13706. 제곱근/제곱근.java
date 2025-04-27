import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        BigInteger N=new BigInteger(sc.next());

        BigInteger left=BigInteger.ZERO;
        BigInteger right=N;
        BigInteger answer=BigInteger.ZERO;
        
        while(left.compareTo(right)<=0){
            BigInteger mid=(left.add(right)).divide(BigInteger.valueOf(2)); //(left+right)/2

            if(mid.multiply(mid).compareTo(N)>=0){ //Math.pow(mid,2)>=N
                answer=mid;
                right=mid.subtract(BigInteger.ONE);
            }else{
                left=mid.add(BigInteger.ONE);
            }
        }

        System.out.println(answer);
    }
}
