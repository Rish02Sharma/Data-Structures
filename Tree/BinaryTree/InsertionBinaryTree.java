package Tree.BinaryTree;

import java.util.*;

public class InsertionBinaryTree {

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
    static Node temp = root;

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


    //Method to insert a node in Level Order(Bredth First)
    public static void insert(Node next, Node temp){
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while(!queue.isEmpty()){
            temp = queue.peek();
            queue.remove();

            if(temp.left == null){
                temp.left = next;
                break;
            }else{
                queue.add(temp.left);
            } 
            
            
            if(temp.right == null){
                temp.right = next;
                break;
            }else {
                queue.add(temp.right);
            }
        }
    }




    public static void main(String args[]){
        root = new Node(10); 
        root.left = new Node(11); 
        root.left.left = new Node(7); 
        root.right = new Node(9); 
        root.right.left = new Node(15); 
        root.right.right = new Node(8);

        //We will Print the tree in Inorder Traversal (Depth First)
        inorder(root);

        //Insert Node in Level order
        insert(new Node(4), root);
        System.out.println("");

        //Print the new Tree in inorder Traversal
        inorder(root);

    }

}