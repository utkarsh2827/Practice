import java.util.*;
public class MaxProfitStockKTrans{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static int getMaxProfit(int arr[], int k){
		int n = arr.length;
		int profit[][] = new int[k+1][n];
		for(int i = 1;i<=k;i++){
			int prevDiff = Integer.MIN_VALUE;
			for(int j = 1;j<n;j++){
				prevDiff = Math.max(prevDiff, profit[i-1][j-1]-arr[j-1]);
				profit[i][j] = Math.max(profit[i][j-1],arr[j]+prevDiff);
			}
		}
		return profit[k][n-1];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		print("Enter number of days:\n");
		int n = sc.nextInt();
		print("Enter elements:\n");
		int arr[] = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		print("Enter number of transactions:\n");
		int k = sc.nextInt();
		int maxProfit = getMaxProfit(arr, k);
		print("Maximum Profit: "+maxProfit+"\n");
	}
}