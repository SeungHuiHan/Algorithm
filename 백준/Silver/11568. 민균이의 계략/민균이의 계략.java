import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] cards=new int[N];

        for(int i=0;i<N;i++){
            cards[i]=sc.nextInt();
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            int card=cards[i];
            int pos= Collections.binarySearch(list,card);
            if(pos<0) pos=-(pos+1);

            if(pos==list.size()){
                list.add(card);
            }else{
                list.set(pos,card);
            }

        }


        System.out.println(list.size());

        
    }
}