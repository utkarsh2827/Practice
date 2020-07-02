import java.util.*;
public class LCABinaryTree{
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
	public LCABinaryTree(){
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
    public Node findLCA(Node root,int a, int b){
    	if(root==null){
    		return root;
    	}
    	if(root.data == a || root.data == b){
    		return root;
    	}

    	Node left_lca = findLCA(root.left,a,b);
    	Node right_lca = findLCA(root.right,a,b);

    	if(left_lca!=null&&right_lca!=null){
    		return root;
    	}

    	return left_lca!=null?left_lca:right_lca;
    }
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		LCABinaryTree tree = new LCABinaryTree();

		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        // tree.root.right.right = new Node(7);

		print("\n\n");
		print("Original Tree:\n");
		tree.printTree("",tree.root,false);

		print("Enter the node values you want LCA of:\n");
		int a = sc.nextInt();
		int b = sc.nextInt();
		print("LCA of the given tree:\n");
		print(tree.findLCA(tree.root, a,b).data+"");
	}
}