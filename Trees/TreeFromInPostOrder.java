import java.util.*;
public class TreeFromInPostOrder
{
	static class Node{
		int data;
		Node left, right;
		public Node(int x){
			data = x;
			left = null;
			right = null;
		}
	}
	static int pIndex = 0;
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void printTree(String prefix, Node n, boolean isLeft) {
        if (n != null) {
        	
        	print(prefix + (isLeft ? "|-- " : "\\-- ") + n.data+"\n");
        	printTree(prefix + (isLeft ? "|   " : "    "), n.left, true);
            printTree(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
    public static Node getTree(int inOrder[], int postOrder[], int inStart, int inEnd, HashMap<Integer,Integer>inMap){
    	if(inStart>inEnd|| pIndex == -1){
    		return null;
    	}

    	Node node = new Node(postOrder[pIndex]);
    	pIndex--;
    	if(inStart==inEnd){
    		return node;
    	}
    	int index = inMap.get(node.data);
    	
    	node.right = getTree(inOrder,postOrder, index+1, inEnd, inMap);
    	node.left = getTree(inOrder,postOrder, inStart, index-1, inMap);
    	return node;
    }
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	print("Enter no. of nodes in the tree:\n");
    	int n = sc.nextInt();
    	print("Enter InOrder:\n");
    	int inOrder[] = new int[n];
    	HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
    	for(int i = 0;i<n;i++){
    		inOrder[i] = sc.nextInt();
    		inMap.put(inOrder[i], i);
    	}
    	print("Enter PostOrder:\n");
    	int postOrder[] = new int[n];
    	for(int i = 0;i<n;i++){
    		postOrder[i] = sc.nextInt();
    	}

    	pIndex = n-1;
    	
    	Node head = getTree(inOrder, postOrder, 0, n-1, inMap);

    	printTree("", head, false);




    }   
                             
}