import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        
        Arrays.sort(arr);
        int M=sc.nextInt();
        
        int[] checkArr=new int[M];
        
        for(int i=0;i<M;i++){
            checkArr[i]=sc.nextInt();
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            boolean flag=binarySearch(arr,checkArr[i]);
            int result=flag?1:0;
            sb.append(result+" ");
        }
        
        System.out.println(sb);
    }
    
    static boolean binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            
            if(arr[mid]==target) return true;
            else if(arr[mid]<target) left=mid+1;
            else right=mid-1;
        }
        
        return false;
    }
}