import java.util.*;
public class GreaterSumTree{
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
	// 10
	// 100 99 999 123 2 34 156 789 76 -1


	Node head;
	static int sum = 0;

	public GreaterSumTree(){
		head = null;
	}

	//Utitlity Functions
	public void addNode(int x){
		if(this.head == null){
			this.head = new Node(x);
			return;
		}
		Node temp = this.head;
		while(true){
			if(x<temp.data){
				if(temp.left==null){
					temp.left = new Node(x);
					return;
				}
				temp = temp.left;
			}
			else{
				if(temp.right == null){
					temp.right = new Node(x);
					return;
				}
				temp = temp.right;
			}
		}
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	// public static void printInOrder(Node root){
	// 	if(root==null){
	// 		return;
	// 	}
	// 	printInOrder(root.left);
	// 	print(root.data + " ");
	// 	printInOrder(root.right);
	// }

	public void printTree(String prefix, Node n, boolean isLeft) {
        if (n != null) {
        	if(this.head!=n){
        		print(prefix + (isLeft ? "|-- " : "\\-- ") + n.data+"\n");
        	}
        	else{
        		print("    "+n.data+"\n");
        	}
            printTree(prefix + (isLeft ? "|   " : "    "), n.left, true);
            printTree(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

	public void greaterSumTrans(Node root){
		if(root==null){
			return;
		}
		greaterSumTrans(root.right);
		sum += root.data;
		root.data = sum;
		greaterSumTrans(root.left);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		GreaterSumTree A = new GreaterSumTree();

		print("Enter no. of tree nodes:\n");
		int n = sc.nextInt();
		print("Enter node values:\n");
		for(int i = 0;i<n;i++){
			A.addNode(sc.nextInt());
		}

		print("\n\n");
		print("Original Tree:\n");
		A.printTree("",A.head,false);

		A.greaterSumTrans(A.head);

		print("\n\n");
		print("Greater Sum Tree:\n");
		A.printTree("",A.head,false);
	}
}