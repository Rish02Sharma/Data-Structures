package Tree.BinaryTree;

import java.util.*;

public class Height{

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

    static int height(Node root){
        if(root == null)
        return 0;

        int lheight = height(root.left) + 1;
        int rheight = height(root.right) + 1;

        if(lheight>rheight)
        return lheight;
        else
        return rheight;
    }


    public static void main(String args[]){
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        int h = height(root);
        System.out.println(h);
    }

}