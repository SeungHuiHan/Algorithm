import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int d=sc.nextInt();
        int k=sc.nextInt();
        int c=sc.nextInt();

        int[] dish=new int[N+k];
        for(int i=0;i<N;i++){
            dish[i]=sc.nextInt();
        }
        for(int i=N;i<N+k;i++){
            dish[i]=dish[i-N];
        }

        int[] sushi=new int[d+1];

        int start=0;
        int maxDish=0;
        int countDish=0;
        for(int end=0;end<N+k;end++){
            if(sushi[dish[end]]==0){
                countDish++;
                sushi[dish[end]]=1;
            }else{
                sushi[dish[end]]++;
            }


            if(end-start+1==k){
                if(sushi[c]==0){
                    maxDish=Math.max(maxDish,countDish+1);
                }else{
                    maxDish=Math.max(maxDish,countDish);
                }

                if(sushi[dish[start]]==1) {
                    sushi[dish[start]]=0;
                    countDish--;
                }
                else sushi[dish[start]]--;

                start++;
            }


        }

        System.out.println(maxDish);



    }
}
