import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int power=-arr[i]; //내림차 순은 - 해줘야함
            int pos= Collections.binarySearch(list,power);

            if(pos<0) pos=-(pos+1);

            if(pos==list.size()){
                list.add(power);
            }else{
                list.set(pos,power);
            }
        }

        System.out.println(n-list.size());
    }
}