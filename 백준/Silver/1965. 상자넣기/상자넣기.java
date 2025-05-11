import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        //가장 긴 증가하는 수열
        ArrayList<Integer> list=new ArrayList<>();
        for(int target:arr){
            int pos=Collections.binarySearch(list,target);
            if(pos<0) pos=-(pos+1);
            
            if(pos==list.size()){
                list.add(target);
            }else{
                list.set(pos,target);
            }
            
        }
        System.out.println(list.size());
    }
}