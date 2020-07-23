// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
import java.util.*;
class RepeatingNumbers{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static List<Integer> getNumbers(int nums[]){
		int xor = 0;
		List<Integer> ans = new ArrayList<Integer>();
		ans.add(0);
		ans.add(0);
		for(int num:nums){
			xor^=num; //finds x^y(non-repeating numbers)
		}
		// resulting xor will have a 1 at a bit position if x and y differ at that bit position.
		// We'll leverage this fact to find one set bit and partition the array into two groups.
		// First group shall contain all the elements where that particular bit is set and the second will have the numbers with that bit unset.
		// We'll use the rightmost set bit as its the easiest to find.
		xor = xor^~(xor-1);//rightmost set bit
		for(int num:nums){
			if((num&xor)==0){
				ans.set(0,ans.get(0)^num);
			}
			else{
				ans.set(1,ans.get(1)^num);
			}
		}
		return ans;

		// the method can be extended to the problem where two numbers have odd occurences while others have even occurences.
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
		print(getNumbers(arr).toString()+"\n");
    }   
                             
}