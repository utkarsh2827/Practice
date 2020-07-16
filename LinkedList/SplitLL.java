import java.util.*;
public class ReverseMtoN{
    static class Node{
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
    public static void printList(Node head){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        Node head = createHead();
        System.out.println("Enter size:");
        int length= sc.nextInt();
        System.out.println("Enter List Elements");
        for(int i =0;i<length;i++){
        	insert(head,sc.nextInt());
        }
        head = head.next;
        System.out.println("Original List");
        printList(head);
        System.out.println("Enter m and n:");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("Reversed List");
        head = reverse(head,m,n);
        printList(head);
    }
}

