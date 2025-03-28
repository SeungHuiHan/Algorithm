import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        int[] prevMax=new int[3];
        int[] prevMin=new int[3];
        int[] currentMax=new int[3];
        int[] currentMin=new int[3];

        int[] arr=new int[3];
        arr[0]=sc.nextInt();
        arr[1]=sc.nextInt();
        arr[2]=sc.nextInt();

        prevMax=arr.clone();
        prevMin=arr.clone();


        for(int i=1;i<N;i++){
            arr[0]=sc.nextInt();
            arr[1]=sc.nextInt();
            arr[2]=sc.nextInt();
            currentMax[0]=Math.max(prevMax[0],prevMax[1])+arr[0];
            currentMax[1]=Math.max(Math.max(prevMax[1],prevMax[2]),prevMax[0])+arr[1];
            currentMax[2]=Math.max(prevMax[1],prevMax[2])+arr[2];

            currentMin[0]=Math.min(prevMin[0],prevMin[1])+arr[0];
            currentMin[1]=Math.min(Math.min(prevMin[1],prevMin[2]),prevMin[0])+arr[1];
            currentMin[2]=Math.min(prevMin[1],prevMin[2])+arr[2];

            prevMax=currentMax.clone();
            prevMin=currentMin.clone();
        }

        int min=Math.min(Math.min(prevMin[0],prevMin[1]),prevMin[2]);
        int max=Math.max(Math.max(prevMax[0],prevMax[1]),prevMax[2]);

        System.out.println(max+" "+min);
    }
}