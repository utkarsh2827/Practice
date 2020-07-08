import java.util.*;

public class ThreeSum{

	public static void getTriplets(int arr[]){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(arr);

		for(int i = 0;i<arr.length;i++){
			if(i>0 && arr[i]==arr[i-1]){
				continue;
			}
			int l = i + 1;
			int r = arr.length - 1;
			
			int x = arr[i];
			while(l<r){
				if(x+arr[l]+arr[r]==0){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(x);
					temp.add(arr[l]);
					temp.add(arr[r]);
					ans.add(temp);
					while(l<r && arr[l]==arr[l+1]){
						l++;
					}
					while(l<r && arr[r]==arr[r-1]){
						r--;
					}
					l++;
					r--;
				}
				else if(x+arr[l]+arr[r]<0){
					l++;
				}
				else{
					r--;
				}
			}

		}
		System.out.println(ans);
	}

	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		print("Enter size of array:\n");

		int n = sc.nextInt();

		print("Enter array elements:\n");

		int arr[] = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.nextInt();
		}

		getTriplets(arr);
	}
}