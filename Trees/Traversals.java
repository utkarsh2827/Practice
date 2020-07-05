import java.util.*;
public class Traversals{
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

	public Traversals(){
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

	public Node get_predecessor(Node node){
		Node start = node.left;
		while(start.right!=null&&start.right!=node){
			start = start.right;
		}
		return start;
	}

	public Node get_successor(Node node){
		Node start = node.right;
		while(start.left!=null&& start.left != node){
			start = start.left;
		}
		return start;
	}

	public static void print(String msg){
		System.out.print(msg);
	}

	// Traversals:
	// PreOrders
	public void preOrder(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public void iterativePreOrder(Node root){
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		while(true){
			if(curr!=null){
				print(curr.data + " ");
				stack.push(curr);
				curr = curr.left;
			}
			else if(!stack.isEmpty()){
				Node x = stack.pop();
				curr = x.right;
			}
			else{
				break;
			}
		}
	}
	public void morrisPreOrder(Node root){
		Node curr = root;
		while(curr!=null){
			if(curr.left==null){
				System.out.print(curr.data+" ");
				curr = curr.right;
			}
			else{
				Node pred = get_predecessor(curr);
				if(pred.right == null){
					System.out.print(curr.data+" ");
					pred.right = curr;
					curr = curr.left;
				}
				else{
					pred.right = null;
					curr = curr.right;
				}

			}
		}
	
	}
	// Inorders
	public void inOrder(Node root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	public void iterativeInOrder(Node root){
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		while(true){
			if(curr!= null){
				stack.push(curr);
				curr = curr.left;
			}
			else if(!stack.isEmpty()){
				Node x = stack.pop();
				System.out.print(x.data+" ");
				curr = x.right;
			}
			else{
				break;
			}
		}
	}
	public void morrisInOrder(Node root){
		Node curr = root;
		while(curr!=null){
			if(curr.left==null){
				System.out.print(curr.data+" ");
				curr = curr.right;
			}
			else{
				Node pred = get_predecessor(curr);
				if(pred.right == null){
					pred.right = curr;
					curr = curr.left;
				}
				else{
					pred.right = null;
					System.out.print(curr.data+" ");
					curr = curr.right;
				}

			}
		}

	}

	public void reverseInOrder(Node root){
		if(root == null){
			return;
		}
		reverseInOrder(root.right);
		System.out.print(root.data + " ");
		reverseInOrder(root.left);
	}
	public void iterativeReverseInOrder(Node root){
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		while(true){
			if(curr!=null){
				stack.push(curr);
				curr = curr.right;
			}
			else if(!stack.isEmpty()){
				Node x = stack.pop();
				System.out.print(x.data+" ");
				curr = x.left;
			}
			else{
				break;
			}
		}
	}
	public void morrisReverseInOrder(Node root){
		Node curr = root;
		while(curr!=null){
			if(curr.right==null){
				System.out.print(curr.data+" ");
				curr = curr.left;
			}
			else{
				Node succ = get_successor(curr);
				if(succ.left == null){
					succ.left = curr;
					curr = curr.right;
				}
				else{
					succ.left = null;
					System.out.print(curr.data+" ");
					curr = curr.left;
				}

			}
		}

	}
	// PostOrders
	public void postOrder(Node root){
		if(root == null){
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	public void iterativePostOrderTwoStacks(Node root){
		if(root==null){
			return;
		}
		Node curr = root;
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(curr);
		while(!stack1.isEmpty()){
			Node x = stack1.pop();
			if(x.left!=null){
				stack1.push(x.left);
			}
			if(x.right!=null){
				stack1.push(x.right);
			}
			stack2.push(x);
		}
		while(!stack2.isEmpty()){
			print(stack2.pop().data+ " ");
		}
	}
	public void iterativePostOrderOneStack(Node root){
		Node curr = root;
		Stack<Node> stack = new Stack<Node>();
		while(true){
			if(curr!=null){
				stack.push(curr.right);
				stack.push(curr);
				curr = curr.left;
			}
			else if(!stack.isEmpty()){
				Node x = stack.pop();
				if(!stack.isEmpty()&&x.right == stack.peek()){
					Node right = stack.pop();
					stack.push(x);
					curr = right;
				}
				else{
					print(x.data+" ");
					curr = null;
				}
			}
			else{
				break;
			}
		}
	}
	public void morrisPostOrder(Node root){
		Node curr = root;
		// while(curr!=null){
			
		// }
		print("I dont understand it!");
	}
	// Breadth First Search
	public void bfs(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node x = q.poll();
			print(x.data+" ");
			if(x.left!=null){
				q.add(x.left);
			}
			if(x.right!=null){
				q.add(x.right);
			}
		}
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		Traversals A = new Traversals();

		print("Enter no. of tree nodes:\n");
		int n = sc.nextInt();
		print("Enter node values:\n");
		for(int i = 0;i<n;i++){
			A.addNode(sc.nextInt());
		}
		print("\n\n\n");
		print("InOrder Traversal:\n");
		A.inOrder(A.head);
		print("\n");
		print("Iterative InOrder Traversal:\n");
		A.iterativeInOrder(A.head);
		print("\n");
		print("Morris InOrder Traversal:\n");
		A.morrisInOrder(A.head);
		print("\n");

		print("\n\n");
		print("PreOrder Traversal:\n");
		A.preOrder(A.head);
		print("\n");
		print("Iterative PreOrder Traversal:\n");
		A.iterativePreOrder(A.head);
		print("\n");
		print("Morris PreOrder Traversal:\n");
		A.morrisPreOrder(A.head);
		print("\n");

		print("\n\n");
		print("PostOrder Traversal:\n");
		A.postOrder(A.head);
		print("\n");
		print("Iterative PostOrder Traversal With Two Stacks:\n");
		A.iterativePostOrderTwoStacks(A.head);
		print("\n");
		print("Iterative PostOrder Traversal With One Stack:\n");
		A.iterativePostOrderOneStack(A.head);
		print("\n");
		print("Morris PostOrder Traversal:\n");
		A.morrisPostOrder(A.head);
		print("\n");

		print("\n\n");
		print("Reverse InOrder Traversal:\n");
		A.reverseInOrder(A.head);
		print("\n");
		print("Iterative Reverse InOrder Traversal:\n");
		A.iterativeReverseInOrder(A.head);
		print("\n");
		print("Morris Reverse InOrder Traversal:\n");
		A.morrisReverseInOrder(A.head);
		print("\n");

		print("\n\n");
		print("Breadth First Order:\n");
		A.bfs(A.head);
		print("\n");
		
	}
}