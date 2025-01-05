import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int K=sc.nextInt();
        
        int bottles=0;
        while(Integer.bitCount(N)>K){ //N에서 1의 개수가 K보다 많을때
            int lowesBit=N & -N; // 가장 낮은 비트를 구함
            bottles+=lowesBit; // 필요한 물병의 크기 추가
            N+=lowesBit; // 물병 추가 후 다시 합침
        }
        
        System.out.println(bottles);
    }
}