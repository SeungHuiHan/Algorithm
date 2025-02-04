import java.util.*;

public class Main{
    static class Node{
        char value;
        Node left,right;

        Node(char value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }

    static HashMap<Character,Node> nodes=new HashMap<>();


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();
        Node root =null;

        for(int i=0;i<n;i++){
            String[] input=sc.nextLine().split(" ");
            char parent=input[0].charAt(0);
            char left=input[1].charAt(0);
            char right=input[2].charAt(0);

            nodes.putIfAbsent(parent,new Node(parent));

            Node parentNodes=nodes.get(parent);

            if(i==0) root=parentNodes;

            if(left!='.'){
                nodes.putIfAbsent(left,new Node(left));
                parentNodes.left=nodes.get(left);
            }

            if(right!='.'){
                nodes.putIfAbsent(right,new Node(right));
                parentNodes.right=nodes.get(right);
            }


        }

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);


    }

    //전위순회법
    private static void preorder(Node node){
        if(node==null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);

    }

    //중위순회법
    private static void inorder(Node node){
        if(node==null) return;

        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);

    }

    //후위순회법
    private static void postorder(Node node){
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);

    }
}