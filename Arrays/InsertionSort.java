import java.util.*;
public class InsertionSort{
	public static void sort(int arr[]){
		int n = arr.length;
		for(int i = 1;i<n;i++){
			int key = arr[i];
			int j = i-1;
			while(j>=0&&arr[j]>key){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String[] args) {
		int arr[] = {99,87,86,100};
		print("Original Array: "+Arrays.toString(arr)+"\n");
		sort(arr);
		print("Sorted Array: "+Arrays.toString(arr)+"\n");
	}
}