package Tree.BinaryTree;

import java.util.*;

public class LeftViewBT{

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

    public static void leftPrint(Node root){
        Node curr = root;

        while(curr != null){
            System.out.print(curr.key + " ");
            if(curr.left != null){
                curr = curr.left;
                continue;
            }else if(curr.right != null){
                curr = curr.right;
                continue;
            }
            break;
        }
    }

    public static void main(String args[]){
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(8);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        leftPrint(root);
    }

}