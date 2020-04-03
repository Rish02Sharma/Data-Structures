package Tree.BinaryTree;

import java.util.*;

public class TreeTraversal{

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
       
       inorder(root.left);
       System.out.print(root.key + " ");
       inorder(root.right);
    }

    //PreOrder Traversal of tree
    static void preorder(Node root){
        if(root == null)
        return;

        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //PostOrder Traversal of Tree
    static void postorder(Node root){
        if(root == null)
        return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
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

        //PreOrder
        System.out.println("PreOrder");
        preorder(root);

        //PostOrder
        System.out.println("PostOrder");
        postorder(root);

    }

}