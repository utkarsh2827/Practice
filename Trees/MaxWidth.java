import java.util.*;
public class MaxWidth{
	static class Node{
		int data;
		Node left, right;
		public Node(){
			this.data = 0;
			this.left = null;
			this.right = null;
		}
		public Node(int x){
			this.data = x;
			this.left = null;
			this.right = null;
		}
	}
	Node root;
	static int max = 1;
	public MaxWidth(){
		root = null;
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public void printTree(String prefix, Node n, boolean isLeft) {
        if (n != null) {
        	if(this.root!=n){
        		print(prefix + (isLeft ? "|-- " : "\\-- ") + n.data+"\n");
        	}
        	else{
        		print("    "+n.data+"\n");
        	}
            printTree(prefix + (isLeft ? "|   " : "    "), n.left, true);
            printTree(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public void helper(Node root, int level, int index, List<Integer> levels){
    	if(root==null){
    		return;
    	}
    	if(level == levels.size()){
    		levels.add(index);
    	}
    	max = Math.max(max, index - levels.get(level)+1);
    	helper(root.left, level+1, 2*index, levels);
    	helper(root.right, level+1, 2*index+1, levels);
    }

    public int calcMaxWidth(Node root){
    	if(root==null){
    		return 0;
    	}
    	List <Integer> levels = new LinkedList<Integer>();
    	helper(root, 0, 0, levels);
    	return max;
    }

    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);

    	MaxWidth tree = new MaxWidth();
    	tree.root = new Node(1);
    	tree.root.left = new Node(3);
    	tree.root.right = new Node(2);
    	tree.root.left.left = new Node(5);

    	print("Example Tree 1:\n");
    	tree.printTree("",tree.root,false);

    	print("Maximum Width of the Tree: " + tree.calcMaxWidth(tree.root) +"\n\n" );

    	tree = new MaxWidth();
    	tree.root = new Node(1);
    	tree.root.left = new Node(3);
    	tree.root.left.left = new Node(5);
    	tree.root.left.left.left = new Node(6);
    	tree.root.right = new Node(2);
    	tree.root.right.right = new Node(9);
    	tree.root.right.right.right = new Node(7);
    	print("Example Tree 2:\n");
    	tree.printTree("",tree.root,false);

    	print("Maximum Width of the Tree: " + tree.calcMaxWidth(tree.root) +"\n" );
    }
}