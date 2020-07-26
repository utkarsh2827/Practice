import java.util.*;
public class DistinctPermutations{
	static HashSet<String> set = new HashSet();
	public static void permute(char s[], int i , int n){
		if(i==n){
			if(set.add(new String(s)))
				System.out.println(s);
			return;
		}
		for(int j = i;j<=n;j++){
			char ch = s[i];
			s[i] = s[j];
			s[j] = ch;
			permute(s,i+1,n);
			ch = s[i];
			s[i] = s[j];
			s[j] = ch;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		permute(s.toCharArray(),0,s.length()-1);
	}
}