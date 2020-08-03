import java.util.*;
public class Jump
{
	public static int jump(int arr[]){
		int n = arr.length;
		int dp[] = new int[n];
		dp[n-1] = arr[n-1];
		dp[n-2] = arr[n-2];
		for(int i = n-3;i>=0;i--){
			if(i==0){
				dp[i] = arr[i] + dp[i+2];
				continue;
			}
			dp[i] = arr[i] + Math.min(dp[i+2],arr[i-1]+dp[i+1]);
		}
		return Math.min(dp[1],dp[0]);
	}
    public static void main(String args[])
    {
    	int arr[] = {1,3,7,5,6,1};
    	System.out.println(jump(arr));
    }   
                             
}