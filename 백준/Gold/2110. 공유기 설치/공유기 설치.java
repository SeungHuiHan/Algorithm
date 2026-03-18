import java.util.*;
//최소의 최대
public class Main{
    
    private static int N,C;
    private static int[] arr;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int answer=0;
        N=sc.nextInt();
        C=sc.nextInt();
        
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int left=0;
        int right=1000000000;
        
        while(left<=right){
            int mid=(left+right)/2; //거리
            
            if(canCut(mid)){
                left=mid+1;
                answer=mid;
            }else{
                right=mid-1;
            }
        }
        
        System.out.println(answer);
        
        
    }
    
    private static boolean canCut(int mid){
        int count=1; //최대 공유기 개수
        int prev=arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]-prev>=mid){
                count++;
                 prev=arr[i];
            } 
        }
        
        return count>=C?true:false;
    }
}