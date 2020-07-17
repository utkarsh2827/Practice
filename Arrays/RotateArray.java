import java.util.*;
public class RotateArray
{
	public static void print(String msg){
		System.out.print(msg);
	}	
	public static void reverse(int arr[], int start, int end){
		while(start<end){
			int temp = arr[start];
			arr[start] = arr[end-1];
			arr[end-1] = temp;
			end--;
			start++;
		}
	}
	public static void rotate(int arr[], int k){
		k = k%arr.length;
		if(k==0){
			return;
		}
		reverse(arr, 0, arr.length);
		reverse(arr, 0, k);
		reverse(arr, k, arr.length);
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
		print("Enter Rotation Factor:\n");
		int k = sc.nextInt();
		rotate(arr, k);
		print(Arrays.toString(arr)+"\n");
    }   
                             
}