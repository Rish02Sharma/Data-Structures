package Tree.BinarySearchTree;

import java.util.*;

public class BSTDelete{

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
    
    //Inserting a node 
    static Node insertBST(Node root, Node newNode){
        if(root == null){
            root = newNode;
            return root;
        }

        if(root.key > newNode.key){
            root.left = insertBST(root.left, newNode);
        }else{
            root.right = insertBST(root.right, newNode);
        }
        return root;
    }

    ///////////////////////// DELETING A NODE IN BST AND BALENCING THE TREE AGAIN ///////////////////////////////


    


    public static void main(String args[]){
        root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);


    }

}