package Tree.BinaryTree;

import java.util.*;

public class InorderStack{

    //Node class to make Tree structure
    static class Node{
        int key;
        Node left, right;

        //constructor
        Node(int data){
            this.key = data;
            left = null;
            right = null;
        }
    }

    //Initialising header
    static Node root;
    static Node temp = root;

    //Inorder Traversal of tree
    static void inorder(Node root){
       if (root == null)
       return;

       Stack<Node> stack = new Stack<>();
        Node current = root;
       while(!stack.isEmpty() || current != null){
        
        while(current != null){
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        System.out.print(current.key + " ");
        current = current.right;

       }
    }

    public static void main(String args[]){
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);

        //Inorder
        System.out.println("InOrder");
        inorder(root);

        // //PreOrder
        // System.out.println("PreOrder");
        // preorder(root);

        // //PostOrder
        // System.out.println("PostOrder");
        // postorder(root);

    }

}