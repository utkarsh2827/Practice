import java.util.*;
public class PartitionSetIntoKSubsets
{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static int partitionRecursive(int n, int k){
		if(k==1||n==k){
			return 1;
		}
		return k*partitionRecursive(n-1,k) + partitionRecursive(n-1,k-1);
	}
	public static int partitionDP(int n, int k){
		int dp[][] = new int[n+1][k+1];
		for(int i = 1;i<=n;i++){
			for(int j =1;j<=k;j++){
				if(j==1||j==i){
					dp[i][j] = 1;
				}
				else{
					dp[i][j] = j*dp[i-1][j] + dp[i-1][j-1];
				}
			}
		}
		return dp[n][k];
	}
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	print("Enter n and k:\n");
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	print("Recursive Approach Answer:\n" + partitionRecursive(n,k)+"\n");
    	print("Dynamic Programming Approach Answer:\n" + partitionDP(n,k)+"\n");
    }                        
}