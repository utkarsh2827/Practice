import java.util.*;
public class QuickSort{
	public static void random(int arr[], int low, int high) 
    { 
      
        Random rand= new Random(); 
        int pivot = rand.nextInt(high-low) + low; 
          
        int temp1=arr[pivot]; 
        arr[pivot]=arr[high]; 
        arr[high]=temp1; 
    } 
	public static int partition(int arr[], int low, int high){
		random(arr,low,high);
		int pivot = arr[high];
		int i = low-1;
		for(int j = low;j<high;j++){
			if(arr[j]<pivot){
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
	public static void quickSort(int arr[], int low, int high){
		if(low<high){
			int pi = partition(arr, low, high);

			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String[] args) {
		int arr[] = {100,99,98,87};
		print("Original Array: "+Arrays.toString(arr)+"\n");
		quickSort(arr,0,arr.length-1);
		print("Sorted Array: "+Arrays.toString(arr)+"\n");
	}
}