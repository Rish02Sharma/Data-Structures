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

    ///////////////////////// DELETING A NODE IN BST AND BALENCING THE TREE AGAIN ///////////////////////////////
    static Node deleteNodeBST(Node root, int key){
        if(root == null){
            return root;
        }

        if(key < root.key){
            root.left = deleteNodeBST(root.left, key);
        }else if(key > root.key){
            root.right = deleteNodeBST(root.right, key);
        }else{
            //This case will handle if Current node key is the key which we want to delete


            //These if else  handles if Node to be deleted has one child then that child replace the node deleted
            //This also handles the case when leef node is to be deleted here null is retured to root.left or root.right
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //Case if a node has two children
            //We replace the node by Inorder Successor of that node(Smallest in the right sub tree)
            root.key = minVal(root.right);
            
            //Now we will delete that key from the right subtree
            root.right = deleteNodeBST(root.right, root.key);
        }
       return root;
    }

    static int minVal(Node root){
        int key = root.key;
        while(root.left != null){
            key = root.left.key;
            root = root.left;
        }
        return key;
    }
    
    // This method mainly calls insertRec() 
    static void insert(int key) 
    { 
        root = insertRec(root, key); 
    } 

    static Node insertRec(Node root, int key) 
    { 
  
        /* If the tree is empty, return a new node */
        if (root == null) 
        { 
            root = new Node(key); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 


    public static void main(String args[]){
        root = new Node(50);
        insert(30); 
        insert(20); 
        insert(40); 
        insert(70); 
        insert(60); 
        insert(80); 

        //Printing whole tree
        treeInorder(root);

        //Deleting leaf node
        deleteNodeBST(root, 20);

        //Updated Tree
        treeInorder(root);
    }

}