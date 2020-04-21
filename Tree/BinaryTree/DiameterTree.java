package Tree.BinaryTree;

public class DiameterTree {

         //Node class to make Tree structure
    static class Node{
        int data;
        Node left, right;

        //constructor
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    //Initialising header
    static Node root;
    static Node temp = root;

    static int diameter = 0;
    public static int diameterOfBinaryTree(Node root) {
        if(root == null)
        return 0;

        int lside = diameterOfBinaryTree(root.left) + 1;
        int rside = diameterOfBinaryTree(root.right) + 1;

        int localDiameter = lside + rside;
        diameter = Math.max(diameter, localDiameter);

        if(lside>rside)
        return lside;
        else 
        return rside;
    }


    public static void main(String args[]){
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);

        diameterOfBinaryTree(root);
    }
}