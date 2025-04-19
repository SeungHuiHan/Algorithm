import java.util.*;

//가장 증가하는 수열!Collections.binarySearch(,);
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int[] ports=new int[n];

        for(int i=0;i<n;i++){
            ports[i]=sc.nextInt();
        }

        ArrayList<Integer> list=new ArrayList<>(); //증가하는 수열 (연속이지 않아도 됨!)
        for(int i=0;i<n;i++){
            int port=ports[i];
            int pos= Collections.binarySearch(list,port);
            if(pos<0) pos=-(pos+1); //음수이면 list에 없는 원소 -(pos+1)인덱스에 넣어야함

            if(pos==list.size())
                list.add(port);
            else{
                list.set(pos,port);
            }

        }

        System.out.println(list.size());

    }
    
}