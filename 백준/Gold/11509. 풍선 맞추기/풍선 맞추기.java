import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[] h=new int[N];
        for(int i=0;i<N;i++){
            h[i]=sc.nextInt();
          
        }
        
        int[] arrows=new int[1000001];
     
        
        int count=0;
        for(int i=0;i<N;i++){
            if(arrows[h[i]]>0){ //층에 화살이 있으면
                arrows[h[i]]--; //화살 하나 감소
            }else{
                count++; //화살이 없으면 개수 증가
            }
            arrows[h[i]-1]++; //바로 아래층 화살 하나 증가
        }
        
        System.out.println(count);
        
    }
}