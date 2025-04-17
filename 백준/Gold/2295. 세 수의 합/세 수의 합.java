import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] unions=new int[N];
        for(int i=0;i<N;i++){
            unions[i]=sc.nextInt();
        }

        Arrays.sort(unions);

        ArrayList<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumList.add(unions[i] + unions[j]);
            }
        }
        Collections.sort(sumList);
        //a+b=d-c ; d도 unions 원소중 하나여야함!

        for(int i=N-1;i>=0;i--){
            int d=unions[i];

            for(int j=0;j<N;j++){
                int c=unions[j];

                int target=d-c; //target=a+b
                if(Collections.binarySearch(sumList,target)>=0){ //a+b가 있는지 확인
                    System.out.println(d);
                    return;
                }
            }
        }


    }
}