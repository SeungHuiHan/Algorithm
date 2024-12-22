import java.util.*;

public class Main{
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> list;

        int T=Integer.parseInt(sc.nextLine());

        for(int i=0;i<T;i++){
            String p=sc.nextLine();
            int n=Integer.parseInt(sc.nextLine());
            int Rcount=0;
            String input=sc.nextLine();
            
            if(input.length()==2){ //빈괄호만 올때
                list=new ArrayList<>(); 
            }else{
                String[] arr=input.substring(1,input.length()-1).split(",");
                list=new ArrayList<>(Arrays.asList(arr));
            }
            
            boolean error=false;

            for(int j=0;j<p.length();j++){
                char c=p.charAt(j);

                if(c=='R'){
                    Rcount++;
                }else if(c=='D'){
                    if(list.isEmpty()){
                        error=true;
                        break ;
                    }
                    if(Rcount%2==0){
                        list.remove(0);
                    }else{
                        list.remove(list.size()-1);
                    }
                }
            }

            if(error){
                System.out.println("error");
                continue;
            }
            
            StringBuilder sb=new StringBuilder("[");
            if(Rcount%2==0){
                for(int k=0;k<list.size();k++){

                    if(k==list.size()-1){
                        sb.append(list.get(k));
                    }else{
                        sb.append(list.get(k)+",");
                    }
                }
            }else{
                for(int k=list.size()-1;k>=0;k--){
                    if(k==0){
                        sb.append(list.get(k));
                    }else{
                        sb.append(list.get(k)+",");
                    }
                }
            }

            sb.append("]");

            System.out.println(sb);
        }

    }
}