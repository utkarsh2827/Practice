import java.util.*;

public class PowerSet{
	public static List<List<Integer>> getPowerSet(int arr[]){
		int n = arr.length;
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		for(int i = 0; i<(1<<n);i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();

			for(int j = 0; j<n;j++){
				if(((1<<j)&i)!=0){
					temp.add(arr[j]);
				}
			}
			ans.add(temp);
		}
		return ans;
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
		System.out.println(getPowerSet(arr));
	}
}