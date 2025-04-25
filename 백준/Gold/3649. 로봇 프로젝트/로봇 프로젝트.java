import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String input;
        
        while((input=bf.readLine())!=null){
            long x= 10000000L *Integer.parseInt(input);

            int n=Integer.parseInt(bf.readLine());
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(bf.readLine());
            }

            Arrays.sort(arr);

            ArrayList<int[]> list=new ArrayList<>();

            int left=0;
            int right=n-1;

            while(left<right){
                long sum=arr[left]+arr[right];

                if(sum==x) {
                    list.add(new int[]{Math.abs(arr[left] - arr[right]), arr[left], arr[right]});
                    left++; //맞을 때에도 이동
                    right--;
                }else if(sum<x) left++;
                else right--;

            }
            Collections.sort(list,(a,b)->Integer.compare(b[0],a[0]));

            if(list.isEmpty()){
                sb.append("danger").append("\n");
            }else{
                int a= Math.min(list.get(0)[1], list.get(0)[2]);
                int b= Math.max(list.get(0)[1], list.get(0)[2]);
                sb.append("yes ").append(a+" ").append(b).append("\n");
            }
        }


        System.out.println(sb);
        
    }
}