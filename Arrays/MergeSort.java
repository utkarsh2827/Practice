import java.util.*;
public class MergeSort{
	public static int merge(int arr[], int start, int mid, int end){
		int m = mid-start+1;
		int n = end-mid;
		int left[] = new int[m];
		int right[] = new int[n];
		int i,j,k;
		int count = 0;
		for(i=0;i<m;i++){
			left[i] = arr[start+i];
		}
		for(i=0;i<n;i++){
			right[i] = arr[mid+1+i];
		}
		i = 0;j=0;k=start;
		while(i<m&&j<n){
			if(left[i]<=right[j]){
				arr[k++] = left[i++];
			}
			else{
				arr[k++] = right[j++];
				count++;
			}
		}
		while(i<m){
			arr[k++] = left[i++];
		}
		while(j<n){
			arr[k++] = right[j++];
		}
		return count;
	}
	public static int mergeSort(int arr[], int l, int h){
		int count = 0;
		if(l<h){
			int mid = l+(h-l)/2;
			count+=mergeSort(arr,l,mid);
			count+=mergeSort(arr,mid+1,h);
			count+=merge(arr,l,mid,h);
		}
		return count;
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String[] args) {
		int arr[] = {1,2,4,3};
		print("Original Array: "+ Arrays.toString(arr)+"\n");
		print("Number of inversions: "+mergeSort(arr,0,arr.length-1)+"\n");
		print("Sorted Array: "+ Arrays.toString(arr)+"\n");
	}
}