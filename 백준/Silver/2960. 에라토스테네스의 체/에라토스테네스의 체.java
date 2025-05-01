import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();

        boolean[] isPrime=new boolean[N+1];
        Arrays.fill(isPrime,true);

        int count=0;

        for(int i=2;i<=N;i++){
            if(isPrime[i]){
                count++;

                if(count==K){
                    System.out.println(i);
                    return;
                }
                for(int j=i*i;j<=N;j+=i){
                    if(isPrime[j]){
                        isPrime[j]=false;
                        count++;

                        if(count==K){
                            System.out.println(j);
                            return;
                        }
                    }

                }
            }
        }

    }
}