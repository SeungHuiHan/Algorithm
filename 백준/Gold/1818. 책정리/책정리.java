import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] books=new int[n];
        for(int i=0;i<n;i++){
            books[i]=sc.nextInt();
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int book=books[i]; 
            int pos= Collections.binarySearch(list,book);

            if(pos<0) pos=-(pos+1);

            if(pos==list.size()){
                list.add(book);
            }else{
                list.set(pos,book);
            }
        }

        System.out.println(n-list.size());
    }
}