import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int N=sc.nextInt();

            int[] stock=new int[N];
            for(int j=0;j<N;j++){
                stock[j]=sc.nextInt();
            }

            long maxPrice=0;
            long sumPrice=0;


            for(int j=N-1;j>=0;j--){
                if(stock[j]>maxPrice){
                    maxPrice=stock[j];
//                    System.out.println("maxPrice="+maxPrice);

                }else{
                    sumPrice+=(maxPrice-stock[j]);
//                    System.out.println("sumPrice="+sumPrice);

                }
            }

            System.out.println(sumPrice);
        }
    }
}