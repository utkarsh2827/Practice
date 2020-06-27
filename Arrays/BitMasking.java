import java.util.*;
public class BitMasking{
	public static int getMajorityElement(int arr[]){
		int number = 0, count = 0;

		for(int i = 0;i<32;i++){
			count = 0;
			for(int j = 0;j<arr.length;j++){
				if((arr[j]&1<<i)!=0){
					count++;
				}
			}
			if(count>arr.length/2){
				number+=1<<i;
			}
		}
		count = 0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i]==number){
				count++;
			}
		}
		if(count>arr.length/2){
			return number;
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