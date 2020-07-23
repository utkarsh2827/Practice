import java.util.*;
public class MinEditDistance{
	public static int editDist(String s, String t){
		int m = s.length();
		int n = t.length();
		int dp[][] = new int[m+1][n+1];
		for(int i = 0;i<=m;i++){
			dp[i][0] = i;
		}
		for(int j = 0;j<=n;j++){
			dp[0][j] = j;
		}
		for(int i = 1;i<=m;i++){
			for(int j = 1;j<=n;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else{
					dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
				}
			}
		}
		return dp[m][n];
	}
	public static void print(String msg){
		System.out.print(msg);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	print("Enter word1:\n");
    	String s = sc.next();
    	print("Enter word2:\n");
    	String t = sc.next();
    	print("Minimum Edit Distance: "+editDist(s,t)+"\n");
    }   
                             
}