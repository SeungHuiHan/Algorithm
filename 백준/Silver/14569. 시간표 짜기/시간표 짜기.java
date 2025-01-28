import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        long[] classes=new long[N];

        for(int i=0;i<N;i++){
            int k=sc.nextInt();
            long bit=0;

            for(int j=0;j<k;j++){
                int t=sc.nextInt();
                bit |=(1L<<(t-1)); //교시를 비트로 전환
            }
            classes[i]=bit;
        }

        int M=sc.nextInt();

        for(int i=0;i<M;i++){
            int p=sc.nextInt();
            long studentBit=0;

            for(int j=0;j<p;j++){
                int t=sc.nextInt();
                studentBit |=(1L<<(t-1));
            }

            int count=0;

            for(int l=0;l<N;l++){
                long classBit=classes[l];

                if((classBit & studentBit) == classBit){
                    count++;
                }
            }

            System.out.println(count);

        }
    }
}