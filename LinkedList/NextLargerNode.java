import java.util.*;
public class NextLargerNode
{	static class Node{
        int data;
        Node next;
        public Node(int x){
            this.data = x;
            this.next = null;
        }
    }
    public static Node newNode(int x){
        return new Node(x);
    }
    public static Node createHead(){
        return newNode(0);
    }
    public static void insert(Node head, int x){
        if(head == null){
            head = newNode(x);
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode(x);

    }
    public static List<Integer> nextLarger(Node head){
    	List<Integer> result = new ArrayList();
    	List<Integer> values = new ArrayList();
    	Node curr = head;
    	while(curr!=null){
    		values.add(curr.data);
    		curr = curr.next;
    		result.add(0);
    	}
    	Stack<Integer> stack = new Stack<Integer>();
    	int n = values.size();
    	stack.push(values.get(n-1));
    	for(int i = n-2;i>-1;i--){
    		while(!stack.isEmpty()){
    			if(values.get(i)<stack.peek()){
    				result.set(i, stack.peek());
    				stack.push(values.get(i));
    				break;
    			}
    			else{
    				stack.pop();
    			}
    		}
    		if(stack.isEmpty()){
    			stack.add(values.get(i));
    			result.set(i,0);
    		}
    	}
    	return result;
    }
    public static void printList(Node head){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
        	String st = temp.next==null?"":"->";
            System.out.print(temp.data + st);
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
        int choice = 1;
        Node head = createHead();
        while(choice == 1){
            System.out.println("Enter node value");
            int x = sc.nextInt();
            insert(head, x);
            System.out.println("Wnna enter more node? 1->YES 2->NO");
            choice = sc.nextInt();
        }
        head = head.next;
        System.out.println("Original List");
        printList(head);

        System.out.println("Next Larger Node values:");
        System.out.println(nextLarger(head));

    }   
                             
}