import java.util.*;
public class LongestSubSequence{
	public static void lcs(String s, String t){
		int m = s.length();
		int n = t.length();
		int dp[][] = new int[m+1][n+1];
		for(int i = 1;i<m+1;i++){
			for(int j = 1;j<n+1;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		int ans = dp[m][n];
		print("Length of longest common subsequence: "+ans+"\n");
		if(ans==0) return;
		char ch[] = new char[ans];
		int i = m;
		int j = n;
		while(i>0&&j>0){
			if(s.charAt(i-1)==t.charAt(j-1)){
				ch[ans-1] = s.charAt(i-1);
				i--;
				j--;
				ans--;
			}
			else if(dp[i-1][j]>dp[i][j-1]){
				i--;
			}
			else{
				j--;
			}
		}
		print("Longest Common Subsequence:\n");
		print(new String(ch));
		print("\n");
	}
	public static void print(String msg){
		System.out.print(msg);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	print("Enter first String:\n");
    	String s = sc.next();
    	print("Enter second String:\n");
    	String t = sc.next();
    	lcs(s,t);
    }   
                             
}