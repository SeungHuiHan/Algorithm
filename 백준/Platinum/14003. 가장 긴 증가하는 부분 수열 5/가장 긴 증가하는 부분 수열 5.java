import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[] arr=new int[N];
        
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
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
        
        Collections.reverse(result);
        System.out.println(result.size());
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        
    }
}