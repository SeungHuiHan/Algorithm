import java.util.*;

//가장 증가하는 수열!Collections.binarySearch(,);
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        int[] poles=new int[N+1];

        for(int i=1;i<=N;i++){
            poles[i]=sc.nextInt();
        }

        ArrayList<Integer> list=new ArrayList<>(); //증가하는 수열 (연속이지 않아도 됨!)
        for(int i=1;i<=N;i++){
            int pole=poles[i];
            int pos= Collections.binarySearch(list,pole);
            if(pos<0) pos=-(pos+1); //음수이면 list에 없는 원소 -(pos+1)인덱스에 넣어야함

            if(pos==list.size())
                list.add(pole);
            else{
                list.set(pos,pole);
            }

        }

        System.out.println(N-list.size());

    }
    
}