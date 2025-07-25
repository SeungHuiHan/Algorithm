//두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 
//예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
//수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 
//그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
//입력:첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
//출력:첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        
        int sum=0;
        int[] a=new int[10];
        
        for(int i=0;i<10;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            a[i]=N%42;
        }
        
        for(int i=0;i<10;i++){
            int n=0;
            for(int j=(i+1);j<10;j++){
                if (a[i]==a[j]){
                    n=1;
                }
            }
            if(n==0)
                    sum+=1;
        }
        
        
        System.out.print(sum);
        
    }
}