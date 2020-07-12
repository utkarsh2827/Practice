import java.util.*;
public class RotateList
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
    public static Node rotate(Node head, int k){
        if(head==null)
            return head;
        int n = 1;
        Node curr = head;
        while(curr.next!=null){
            n++;
            curr = curr.next;
        }
        k%=n;
        if(k==0){
            return head; 
        }
        Node temp = head;
        for(int i =1;i<n-k;i++){
            temp = temp.next;
        }

        curr.next = head;
        head = temp.next;
        temp.next = null;
        return head;
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
        System.out.print("Enter rotating number:\n");
        int k = sc.nextInt();
        head = head.next;
        System.out.println("Original List");
        printList(head);

        System.out.println("Rotated List:");
        printList(rotate(head, k));

    }   
                             
}