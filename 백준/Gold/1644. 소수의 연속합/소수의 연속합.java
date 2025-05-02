import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        if (N < 2) {
            System.out.println(0);
            return;
        }

        boolean[] isPrime=new boolean[N+1];


        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;

//        for(int i=2;i<=N;i++){
//            if(isPrime[i]){
//                for(int j=i*i;j<=N;j+=i){
//                    isPrime[j]=false;
//                }
//            }
//        }

        for(int i=2;i*i<=N;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=N;j+=i){
                    isPrime[j]=false;
                }
            }
        }



        ArrayList<Integer> list=new ArrayList<>();
        for(int i=2;i<=N;i++){
            if(isPrime[i]){
                list.add(i); //소수만 집어넣기
            }
        }

        int count=0;

        int start=0;
        int temp=0;
        for(int end=0;end<list.size();end++){
            temp+=list.get(end);


            while(temp>N && start<=end){
                temp-=list.get(start);
                start++;

            }

            if(temp==N){
                count++;

            }
        }


        System.out.println(count);



    }
}