package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class BTVerticalOrder {
    
    public static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

	static void verticalOrder(Node root)
    {
        // add your code here
        
        Queue<QueuePack> q = new LinkedList<>();
        q.add(new QueuePack(0, root));
        Node temp;
        
        while(!q.isEmpty()){
            QueuePack qp = q.remove();
            temp = qp.tnode;
            int lvl = qp.level;
            
        if(map.containsKey(lvl)){
            map.get(lvl).add(temp.data);
        }else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(temp.data);
            map.put(lvl, list);
        }
            
            if(temp.left != null)
            q.add(new QueuePack(lvl-1, temp.left));
            
            if(temp.right != null)
            q.add(new QueuePack(lvl+1, temp.right));
        }
    }

	public static void display() { // print the bottom view.
        Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			for(int i=0; i<map.get(key).size(); i++){
			    System.out.print(map.get(key).get(i) + " ");
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
        root.right.right = new Node(8);
        root.right.left = new Node(9);
		// root.right.right.left = new Node(30);

		verticalOrder(root);
		display();
	}

}
