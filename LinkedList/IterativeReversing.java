import java.util.*;
public class IterativeReversing{
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

    public static Node reverse(Node head){
        if(head==null){
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String args[]){
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
        System.out.println("Reversed List");
        head = reverse(head);
        printList(head);
    }
}

