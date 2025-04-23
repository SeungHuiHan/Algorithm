import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner(System.in);
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(bf.readLine());
        int[] arr=new int[N];
        
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        
        ArrayList<Integer> list=new ArrayList<>();
        int[] indexList=new int[N]; //arr[i]가 LIS몇번쨰 들어갔는지
        int[] prev=new int[N]; //연결 추적
        Arrays.fill(prev,-1); //초기화
        
        int[] posToIndex=new int[N]; //list.get(i)위치에 실제 arr의 인덱스가 들어갔는지
        
        int lisLen=0;
        
        for(int i=0;i<N;i++){
            int a=arr[i];
            int pos=Collections.binarySearch(list,a);
            if(pos<0) pos=-(pos+1);
            
            if(pos==list.size()){
                list.add(a);
            }else{
                list.set(pos,a);
            }
            
            indexList[i]=pos; //a는 pos번째 자리
            posToIndex[pos]=i; //list[pos]는 실제 arr의 i번째 값
            
            if(pos>0) prev[i]=posToIndex[pos-1];
            if(pos+1>lisLen) lisLen=pos+1;
            
        }
        
        // 역추적: 마지막 원소부터 prev[]를 따라가며 수열 복원
        int cur=posToIndex[lisLen-1];
        ArrayList<Integer> result=new ArrayList<>();
        
        while(cur!=-1){
            result.add(arr[cur]);
            cur=prev[cur];
        }
        
        StringBuilder sb=new StringBuilder();
        Collections.reverse(result);
        sb.append(result.size()).append("\n");
        for(int i=0;i<result.size();i++){
            sb.append(result.get(i)+" ");
        }
        System.out.println(sb);
    }
}