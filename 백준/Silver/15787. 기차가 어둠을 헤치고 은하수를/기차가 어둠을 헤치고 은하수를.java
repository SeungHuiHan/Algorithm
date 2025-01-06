import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> set=new HashSet<>();
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] trains=new int[N+1];

        for(int j=0;j<M;j++){
            int command=sc.nextInt();
            int i=sc.nextInt();

            if(command==1){
                int x=sc.nextInt();
                trains[i]|=(1<<(x-1));
            }else if(command==2){
                int x=sc.nextInt();
                trains[i]&=~(1<<(x-1));
            }else if(command==3){
                trains[i]<<=1;
                trains[i] &=((1<<20)-1); //20비트가 넘지 못하도록
            }else if(command==4){
                trains[i]>>=1;
            }
        }

        for(int i=1;i<=N;i++){

                set.add(trains[i]);
            
        }

        System.out.println(set.size());
    }
}