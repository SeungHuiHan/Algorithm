import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        Queue<String> queue=new LinkedList<>();
        
        HashSet<String> set=new HashSet<>(); //추월한 차량

        int N=Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++){
            queue.add(bf.readLine());
        }

        int count=0;
        int index=0;
        for(int i=0;i<N;i++){
            String car=bf.readLine();
            //System.out.println("터널전 "+map.get(i)+" 터널 후"+car);
            
            while(!queue.isEmpty() && set.contains(queue.peek())){ //이미 추월당항 차량이면 queue뺌
                queue.poll();
            }
            
            if(!queue.isEmpty() && queue.peek().equals(car)){ //순서가 같으면
                queue.poll();
            }else{
                count++; //추월당한 차량이면
                set.add(car);
            }
        }
        System.out.println(count);
    }
}