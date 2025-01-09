import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[][] arr=new int[N][2];
        
        for(int i=0;i<N;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        
        
        int[] conferenceRoom=new int[N];
        for(int i=0;i<N;i++){
            
            for(int j=0;j<N;j++){
                if(conferenceRoom[j]<=arr[i][0]){
                    conferenceRoom[j]=arr[i][1];
                    break;
                }
            }
        }
        
        int conferenceCount=0;
        for(int i:conferenceRoom){
            if(i!=0){
                conferenceCount++;
            }else break;
        }
        
        System.out.println(conferenceCount);
    }
}