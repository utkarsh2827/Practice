import java.util.*;
public class Knapsack01{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static int getProfit(int wts[], int profit[], int capacity){
		int n = wts.length;
		int dp[][] = new int[n][capacity+1];
		for(int i = 0; i<n;i++){
			for(int j = 0;j<=capacity;j++){
				if(i==0||j==0){
					dp[i][j] = 0;
				}
				else if(wts[i]<=j){
					dp[i][j] = Math.max(dp[i-1][j-wts[i]]+profit[i],dp[i-1][j]); 
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n-1][capacity];
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		print("Enter number of objects:\n");
		int n = sc.nextInt();
		int wts[] = new int[n+1];
		int profit[] = new int[n+1];
		print("Enter weights of objects:\n");
		for(int i = 1;i<=n;i++){
			wts[i] = sc.nextInt();
		}
		print("Enter profits for each object:\n");
		for(int i = 1; i<=n;i++){
			profit[i] = sc.nextInt();
		}
		print("Enter capacity of knapsack:\n");
		int capacity = sc.nextInt();
		print("Maximum Profit: " + getProfit(wts, profit, capacity) + "\n");
	}
}