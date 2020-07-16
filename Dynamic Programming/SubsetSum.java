import java.util.*;
public class SubsetSum{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static boolean checkSumBT(int arr[], int i, int k){
		if(k==0)
			return true;
		if(i==arr.length)
			return false;
		return checkSumBT(arr,i+1,k)||checkSumBT(arr,i+1,k-arr[i]);
	}

	public static boolean checkSumDP(int arr[], int k){
		boolean dp[][] = new boolean[arr.length+1][k+1];
		for(int i = 0;i<=k;i++){
			dp[0][i] = false;
		}
		for(int i = 0;i<=arr.length;i++){
			dp[i][0] = true;
			
		}
		
		for(int i = 1;i<=arr.length;i++){
			for(int j = 1;j<=k;j++){
				if(arr[i-1]<=j)
					dp[i][j] = dp[i-1][j]||dp[i-1][j-arr[i-1]];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[arr.length][k];
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	print("Enter number of set elements:\n");
    	int n = sc.nextInt();
    	int arr[] = new int[n];
    	print("Enter set elements:\n");
    	for(int i=0;i<n;i++){
    		arr[i] = sc.nextInt();
    	}
    	print("Enter target sum:\n");
    	int k = sc.nextInt();
    	print("Backtracking Answer: " + checkSumBT(arr,0,k)+"\n");
    	print("DP Answer: " + checkSumDP(arr,k)+"\n");
    }   
                             
}