import java.util.*;
public class MooresVoting{
	public static int getMajorityElement(int arr[]){
		int count = 1;
		int me = arr[0];
		for(int i = 1;i<arr.length; i++){
			if(arr[i] == me){
				count++;
			}
			else {
				count--;
				if(count == 0){
					me = arr[i];
					count++;
				}
			}
		}
		count = 0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i]==me){
				count++;
			}
		}
		if(count>arr.length/2){
			return me;
		}
		return -1;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int n = sc.nextInt();
		System.out.println("Enter array elements");
		int arr[] = new int[n];
		for(int i =0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		int x = getMajorityElement(arr);

		if(x==-1){
			System.out.println("No majority element exists");
		}
		else{
			System.out.println("Majority Element: "+ x);
		}
	}
}