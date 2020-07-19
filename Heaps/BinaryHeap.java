import java.util.*;
public class BinaryHeap{
	int arr[];
	int end;
	public BinaryHeap(int n){
		arr = new int[n+1];
		end = 0;
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public int parent(int i){
		return (i)/2;
	} 
	public int left(int i){
		return 2*i+1;
	}
	public int right(int i){
		return 2*i+2;
	}
	public void heapify(int i){
		while(i/2>0){
			if(arr[i]<arr[parent(i)]){
				int temp = arr[i];
				arr[i] = arr[parent(i)];
				arr[parent(i)] = temp;
			}
			i/=2;
		}
	}
	public void insert(int x){
		arr[end] = x;
		end++;
		heapify(end);
				
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		print("Enter heap size:\n");
		int n = sc.nextInt();
		BinaryHeap h = new BinaryHeap(n);
		print("Enter heap elements:\n");
		for(int i = 0;i<n;i++){
			h.insert(sc.nextInt());
		}
		print(Arrays.toString(h.arr)+"\n");
	}
}