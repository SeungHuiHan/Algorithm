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
        int count=0;
        for(int i=0;i<N;i++){
            int target=arr[i];

            int left=0;
            int right=N-1;

            while(left<right){
                
                if(left==i){ 
                    left++;
                    continue;
                }
                if(right==i){ 
                    right--;
                    continue;
                }

                int sum=arr[left]+arr[right];
                if(target==sum){
                    count++;
                    break;
                }
                if(sum<target) left++;
                else right--;

            }
        }

        System.out.println(count);
    }
}