import java.util.*;
public class MedianOfStream{
	static double median = Integer.MIN_VALUE;
	static PriorityQueue<Integer> greater = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(10,Collections.reverseOrder());
	public static void insert(int x){
		if(smaller.isEmpty()&&greater.isEmpty()){
			smaller.add(x);
			median = x;
			return;
		}
		else if(smaller.size()>greater.size()){
			if(x<median){
				greater.add(smaller.poll());
				smaller.add(x);
			}
			else{
				greater.add(x);
			}
			median = (smaller.peek()+greater.peek())*0.5;
		}
		else if(smaller.size()<greater.size()){
			if(x>median){
				smaller.add(greater.poll());
				greater.add(x);
			}
			else{
				smaller.add(x);
			}
			median = (smaller.peek()+greater.peek())*0.5;		
		}
		else{
			if(x<median){
				smaller.add(x);
				median =  smaller.peek();
			}
			else{
				greater.add(x);
				median = greater.peek();
			}
		}
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 1;
		print("Enter a number\n");
		int n = sc.nextInt();
		insert(n);
		print("Current median: "+median+"\n");
		print("Press 1 for entering more numbers:\n");
		choice = sc.nextInt();
		while(choice==1){
			print("Enter a number\n");
			n = sc.nextInt();
			insert(n);
			print("Current median: "+median+"\n");
			print("Press 1 for entering more numbers:\n");
			choice = sc.nextInt();
		}
	}
}