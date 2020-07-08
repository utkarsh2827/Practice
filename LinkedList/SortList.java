import java.util.*;
public class SortList{
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

    public static Node getMiddle(Node head){
        if (head == null) 
            return head; 
  
        Node slow = head, fast = head; 
  
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    }

    public static Node merge(Node left, Node right){
        if(left==null){
            return right;
        }
        if(right == null){
            return left;
        }

        Node res = null;

        if(left.data<=right.data){
            res = left;
            res.next = merge(left.next, right);
        }

        else{
            res = right;
            res.next = merge(left, right.next);
        }

        return res;
    }

    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node middle = getMiddle(head);
        Node next_to_middle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(next_to_middle);

        Node result = merge(left,right);

        return result;
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
        System.out.println("Sorted List");
        head = mergeSort(head);
        printList(head);
    }
}

