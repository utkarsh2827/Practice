import java.util.*;
public class SockDrawer
{
	public static int recurse(int currA,int currB,int currC,int a, int b, int c, int n){
		if(n==1){
			int ans = 0;
			if((currA+1)%2==0||(currC+1)%2==0||(currB+1)%2==0) return 1;
			if(a>0) ans++;
			if(b>0) ans++;
			if(c>0) ans++;
			return ans==0?0:ans+1;
		}
		int max,i,j,k;
		i = j = k = Integer.MIN_VALUE;
		if(a>0){
			if((currA+1)%2==0){
				i = 1 + recurse(currA+1,currB,currC,a-1,b,c,n-1);
			}
			else{
				i = 1 + recurse(currA+1,currB,currC,a-1,b,c,n);
			}
		}
			
		if(b>0){
			if((currB+1)%2==0){
				j = 1 + recurse(currA,currB+1,currC,a,b-1,c,n-1);
			}
			else{
				j = 1 + recurse(currA,currB+1,currC,a,b-1,c,n);
			}
		}
		if(c>0){
			if((currC+1)%2==0){
				k = 1 + recurse(currA,currB,currC+1,a,b,c-1,n-1);
			}
			else{
				k = 1 + recurse(currA,currB,currC+1,a,b,c-1,n);
			}
		}
		return Math.max(i,Math.max(j,k));
	}
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(recurse(0,0,0,16,6,10,sc.nextInt()));
    	
    }   
                             
}