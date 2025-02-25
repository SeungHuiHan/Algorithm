import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        int l=sc.nextInt();
        int r=sc.nextInt();
        int x=sc.nextInt();
        
        for(int i=l;i<=r;i++){
            list.add((i|x));
        }
        
        Collections.sort(list);
        
        int n=0;
        for(int  i:list){
            if(n!=i){
                break;
            }else{
                n++;
            }
        }
        
        System.out.println(n);
    }
}