import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int a=sc.nextInt();
            map.put(a,map.getOrDefault(a,0)+1);
        }
        
        int idx=0;
        int[] arr=new int[map.size()];
        for(Integer key:map.keySet()){
            arr[idx]=key;
            idx++;
        }
        
        Arrays.sort(arr);
        
        int M=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<M;i++){
            int m=sc.nextInt();
            
            int left=0;
            int right=arr.length-1;
            boolean flag=false;
            
            while(left<=right){
                int mid=(left+right)/2;
                
                if(arr[mid]==m){
                    flag=true;
                    sb.append(map.get(m)+" ");
                    break;
                }else if(arr[mid]>m){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            
            if(flag==false) sb.append(0+" ");
        }
        
       System.out.println(sb);
    }
}