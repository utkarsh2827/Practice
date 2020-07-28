import java.util.*;
public class MaxProfitStockOneTrans{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		print("Enter number of days:\n");
		int n = sc.nextInt();
		print("Enter Stock prices:\n");
		int arr[] = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		int maxProfit = Integer.MIN_VALUE;
		int i = 0;
		while(i<n-1){
			int profit = 0;
			while(i<n-1&&arr[i]<arr[i+1]){
				profit+=arr[i+1]-arr[i];
				i++;
			}
			maxProfit = Math.max(maxProfit,profit);
			if(profit==0)i++;
		}
		print("Maximum Profit: "+maxProfit+"\n");
	}
}