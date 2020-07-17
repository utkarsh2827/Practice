import java.util.*;
public class MoveZeros{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void move(int arr[]){
		Queue<Integer> zeros = new LinkedList<Integer>();
		for(int i=0;i<arr.length;i++){
			if(arr[i]==0){
				zeros.add(i);
			}
			else{
				if(zeros.isEmpty()){
					continue;
				}
				int j = zeros.poll();
				arr[j] = arr[i];
				arr[i] = 0;
				zeros.add(i); 
			}
		}
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
		print("Enter size:\n");
		int n = sc.nextInt();
		print("Enter elements:\n");
		int arr[] = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		print("Original Array: "+Arrays.toString(arr)+"\n");
		move(arr);
		print("Array after moving zeros: "+Arrays.toString(arr)+"\n");
    }   
                             
}