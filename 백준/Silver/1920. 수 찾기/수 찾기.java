import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        int N=sc.nextInt();
        int[] A=new int[N];

        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        Arrays.sort(A);

        int M=sc.nextInt();
        int[] B=new int[M];
        for(int i=0;i<M;i++){
            B[i]=sc.nextInt();
        }



        StringBuilder sb=new StringBuilder();

        for(int i=0;i<M;i++){
            int left=0;
            int right=N-1;

            int target=B[i];

            boolean found = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (A[mid] == target) {
                    found = true;
                    break;
                } else if (A[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(found ? 1 : 0).append("\n");




        }



        System.out.println(sb);
    }
}