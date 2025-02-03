import java.util.*;

public class Main{
    
    private static StringBuilder sb=new StringBuilder();
    static class TrieNode{
        Map<String,TrieNode> children = new TreeMap<>();
    }
    
    static class Trie{
        TrieNode root=new TrieNode();
        
        void insert(String[] foods){
             TrieNode current = root;
            for(String food:foods){
                current.children.putIfAbsent(food, new TrieNode()); // 없는 경우에만 추가
                current = current.children.get(food);
            }
        }
        
        void print(TrieNode node,int depth){
             for (String key : node.children.keySet()) {
                System.out.println("--".repeat(depth) + key); // 층(depth) 만큼 "--" 추가
                print(node.children.get(key), depth + 1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Map<String,List<String>> map=new TreeMap<>();
        
        int N=sc.nextInt();
         Trie trie=new Trie();
        
        for(int i=0;i<N;i++){
            int K=sc.nextInt();
           
            String[] foods=new String[K];
            
            for(int j=0;j<K;j++){
                foods[j]=sc.next();
            }
            
            
            trie.insert(foods);
        }
        
        trie.print(trie.root,0);
        
    }
}