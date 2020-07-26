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
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if(l<end&&arr[l]<arr[smallest]){
			smallest = l;
		}
		if(r<end&&arr[r]<arr[smallest]){
			smallest = r;
		}
		if(smallest!=i){
			swap(smallest,i);
			heapify(smallest);
		}
	}
	public void decreaseKey(int i, int val){
		arr[i] = val;
		while(i!=0&&arr[parent(i)]>arr[i]){
			swap(i,parent(i));
			i = parent(i);
		}
	}
	public void deleteKey(int i){
		decreaseKey(i,Integer.MIN_VALUE);
		extract_min();
	}
	public void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public void insert(int x){
		if(end==arr.length){
			print("Overflow!\n");
			return;
		}
		arr[end] = x;
		int i = end;
		end++;
		while(i!=0&&arr[parent(i)]>arr[i]){
			swap(i,parent(i));
			i = parent(i);
		}		
	}
	int extract_min(){
		if(end<=0) return Integer.MAX_VALUE;
		if(end==1){
			end--;
			return arr[0];
		}
		int root = arr[0];
		arr[0] = arr[--end];
		heapify(0);
	}
	int getMin(){
		if(end<=0) return Integer.MAX_VALUE;
		return arr[0];
	}
	public static void print(String msg){
		System.out.print(msg);
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