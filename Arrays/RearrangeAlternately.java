import java.util.*;
public class RearrangeAlternately{
	// arr[i] = arr[i] + arr[j]%me*me;
	// Original arr[i]:arr[i]%me;
	// Rearranged arr[i]:arr[i]/me;
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void rearrange(int arr[]){
		int i = 0, j = arr.length-1;
		int max = Integer.MIN_VALUE;
		for(int k = 0;k<=j;k++){
			max = Math.max(max, arr[k]);
		}
		max++;
		for(int k = 0;k<arr.length;k++){
			if(k%2==0){
				arr[k] = arr[k]+(arr[j]%max)*max;
				j--;
			}
			else{
				arr[k] = arr[k] + (arr[i]%max)*max;
				i++;
			}
		}
		for(int k = 0;k<arr.length;k++){
			arr[k]/=max;
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
		rearrange(arr);
		print("Rearranged Array: "+Arrays.toString(arr)+"\n");
    }   
                             
}