package Tree.BinaryTree;

import java.util.*;

public class DeletionBinaryTree {

    //To add a new node
   static class Node{
        int key;
        Node left, right;

        Node(int data){
            this.key = data;
            left = null;
            right = null;
        }
    }

    //Head node of tree
    static Node root;
    static Node deepest = root;

    //Inorder Traversal of the tree
    public static void inorder(Node root){
        //Empty tree
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

// function to delete the given deepest node (d_node) in binary tree 
public static void deleteDeepest(Node root, Node d_node){
    Queue<Node> q = new LinkedList<>(); 
    q.add(root); 

    // Do level order traversal until last node 
    Node temp = null;
    while (!q.isEmpty()) { 
        temp = q.peek(); 
        q.remove(); 
        
        if (temp == d_node) { 
            temp = null; 
            d_node = null;
            return; 
        } 
        if (temp.right != null) { 
            if (temp.right == d_node) { 
                temp.right = null; 
                d_node = null;
                return; 
            } 
            else
                q.add(temp.right); 
        } 
  
        if (temp.left != null) { 
            if (temp.left == d_node) { 
                temp.left = null; 
                d_node = null;
                return; 
            } 
            else
                q.add(temp.left); 
        } 
    } 

}

// Method to delete element in binary tree 
public static Node deletion(Node root, int key) 
{ 
    if (root == null) 
        return null; 
  
    if (root.left == null && root.right == null) { 
        if (root.key == key) 
            return null; 
        else
            return root; 
    } 
  
    Queue<Node> q = new LinkedList<>(); 
    q.add(root);   
    Node temp = null; 
    Node key_node = null; 
  
    // Do level order traversal to find deepest 
    // node(temp) and node to be deleted (key_node) 
    while (!q.isEmpty()) { 
        temp = q.peek(); 
        q.remove(); 
  
        if (temp.key == key) 
            key_node = temp; 
  
        if (temp.left != null) 
            q.add(temp.left); 
  
        if (temp.right != null) 
            q.add(temp.right); 
    } 
  
    if (key_node != null) { 
        int x = temp.key; 
        deleteDeepest(root, temp); 
        key_node.key = x; 
    } 
    return root; 
} 

    public static void main(String args[]){
        root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.left.right = new Node(12); 
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8);

        //Print the tree in Inorder Traversal (Depth First)
        System.out.println("Inorder traversal Tree before deletion ");
        inorder(root);

        //Insert Node in Level order
        deletion(root, 12);

        //Print the new Tree in inorder Traversal
        System.out.println("Inorder traversal Tree after deletion ");
        inorder(root);
    }
}