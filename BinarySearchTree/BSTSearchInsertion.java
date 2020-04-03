package BinarySearchTree;

import java.util.*;

public class BSTSearchInsertion{

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

    //Tree Inorder
    static void treeInorder(Node root){
        //Base condition
        if(root == null){
            return;
        } 

        treeInorder(root.left);
        System.out.println(root.key);
        treeInorder(root.right);
    }


    //Method to search a key and return  the node
    static Node searchNodeBST(int key){
        Node temp = root;

        while(temp != null){
            if(temp.key == key){
                return temp;
            }

            if(temp.key > key){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return null;
    }

    //Method for Recursive search
    static Node recursiveSearchBST(Node root, int key){
        //Base condition
        if(root == null || root.key == key){
            return root;
        }

        //Recursive condition
        if(root.key > key){
           return recursiveSearchBST(root.left, key);
        }else{
           return recursiveSearchBST(root.right, key);
        }

    }

    ////////////////////////////////// INSERTING A NEW NODE IN BST //////////////////////////////////////////////////

    //Method to insert a new node
    //Node is always inserted at the Leaf Nodes
    static Node insertNodeBST(Node root, Node newNode){
        if(root == null){
            root = newNode;
            return root;
        }

        //we will get a key which will determine the place to insert node

        if(root.key > newNode.key){
            root.left = insertNodeBST(root.left, newNode);
        }else{
            root.right = insertNodeBST(root.right, newNode);
        }
        return root;
    } 

    public static void main(String args[]){
        root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);

        Node found = searchNodeBST(9);
        Node foundRec = recursiveSearchBST(root, 3);
        System.out.println(foundRec.key);

        insertNodeBST(root, new Node(7));
        
        //Print the updated Tree
        treeInorder(root);
    }

}