import java.util.*;
public class BalancedBST{
	static class Node{
		int data, height;
		Node left;
		Node right;
		public Node(){
			data = 0;
			left = null;
			right = null;
			height = 1;
		}
		public Node(int x){
			data = x;
			left = null;
			right = null;
			height = 1;
		}
	}
	Node root;
	public BalancedBST(){
		root = null;
	}
	public int height(Node node){
		if(node == null){
			return 0;
		}
		return node.height;
	}
	public int getBalanceFactor(Node node){
		if(node == null){
			return 0;
		}
		return height(node.left)-height(node.right);
	}
	public Node leftRotate(Node node){
		Node temp = node.right;
		node.right = node.right.left;
		temp.left = node;
		node.height = Math.max(height(node.left), height(node.right))+1;
		temp.height = Math.max(height(temp.left), height(temp.right))+1;
		return temp;
	}
	public Node rightRotate(Node node){
		Node temp = node.left;
		node.left = node.left.right;
		temp.right = node;
		node.height = Math.max(height(node.left), height(node.right))+1;
		temp.height = Math.max(height(temp.left), height(temp.right))+1;
		return temp;
	}
	public Node addNode(Node node, int x){
		if(node == null){
			return (new Node(x));
		}
		if(node.data>x){
			node.left = addNode(node.left,x);
		}
		else{
			node.right = addNode(node.right,x);
		}

		node.height = 1+Math.max(height(node.left), height(node.right));

		int bf = getBalanceFactor(node);
		// print(node.data+" "+bf+"\n");
		// Left-Left Case
		if(bf>1 && x<node.left.data){
			return rightRotate(node);
		}
		// Right-Right Case
		if(bf<-1 && x>=node.right.data){
			return leftRotate(node);
		}

		// Left-Right Case
		if(bf>1 && x>node.left.data){
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right-Left Case
		if(bf<-1 && x<=node.right.data){
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;

	}
	public Node get_successor(Node node){
		if(node==null || node.left==null){
			return node;
		}
		return get_successor(node.left);
	}
	public Node delete(Node node,int x){
		if(node==null){
			return node;
		}
		if(node.data>x){
			node.left = delete(node.left,x);
		}
		else if(node.data<x){
			node.right = delete(node.right,x);
		}
		else{
			if(node.left==null){
				node = node.right;
				return node;
			}
			if(node.right==null){
				node = node.left;
				return node;
			}

			Node temp = get_successor(node.right);
			node.data = temp.data;
			node.right = delete(node.right,temp.data);
		}
		if(node==null)
			return node;
		node.height = 1+Math.max(height(node.left), height(node.right));

		int bf = getBalanceFactor(node);
		// print(node.data+" "+bf+"\n");
		// Left-Left Case
		if(bf>1 && x<node.left.data){
			return rightRotate(node);
		}
		// Right-Right Case
		if(bf<-1 && x>=node.right.data){
			return leftRotate(node);
		}

		// Left-Right Case
		if(bf>1 && x>node.left.data){
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right-Left Case
		if(bf<-1 && x<=node.right.data){
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void insert(int x){
		this.root = addNode(this.root, x);
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
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		BalancedBST A = new BalancedBST();

		print("Enter no. of tree nodes:\n");
		int n = sc.nextInt();
		print("Enter node values:\n");
		for(int i = 0;i<n;i++){
			A.insert(sc.nextInt());
		}

		print("\nConstructed Tree:\n");
		A.printTree("", A.root, false);

		A.delete(A.root,4);
		A.printTree("", A.root, false);


	}
}