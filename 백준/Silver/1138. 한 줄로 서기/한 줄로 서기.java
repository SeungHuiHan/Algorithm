import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++) arr[i]=-1;
        
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            int blankCount=0;
            int index=0;
            
          
            while(true){
                if(arr[index]==-1){
                    if(blankCount==n){
                        arr[index]=i+1;
                        break;
                    }
                        blankCount++;
                }
                index++;
            }
        }
        
        
        for(int a:arr)
            System.out.println(a);
    }
}