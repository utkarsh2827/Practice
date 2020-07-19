import java.util.*;
public class NumOfLengthNandLessThanK{
	static int lower_bound(ArrayList<Integer> A, int target){
		int lo = 0;
		int hi = A.size();
		while(lo<hi){
			int mid = (lo+hi)/2;
			if(A.get(mid)<target) lo = mid+1;
			else hi = mid;
		}
		return lo;
	}
	static int solve(ArrayList<Integer> A, int B, int C) {
	    int n = A.size();
	    int result = 0;

	    // A = [0, 0, 1, 2, 2, 3] -> A = [0, 1, 2, 3]
	    Set<Integer> aSet = new HashSet<>();
	    for (int d : A) {
	        aSet.add(d);
	    }
	    A.clear();
	    A.addAll(aSet);
	    
	    // C = 123  ->  cList = [1, 2, 3]
	    ArrayList<Integer> cList = new ArrayList<>();
	    while(C > 0) {
	        cList.add(0, C % 10);
	        C /= 10;
	    }
	    if (cList.size() < B) {
	        // A = [0, 1, 2, 5]
	        // B = 4
	        // C = 10
	        // There is no value less than 10 and which has 4 digits.
	        return 0;
	    }
	    if (B < cList.size()) {
	        // A = [1, 5, 6, 9]
	        // B = 2
	        // C = 101
	        // "101" has 3 digits, but B is 2.
	        // So we need to convert C to the maximum value of the number which has 2 digits.
	        C = (int)Math.pow(10, B) - 1;
	        cList.clear();
	        while(C > 0) {
	            cList.add(0, C % 10);
	            C /= 10;
	        }
	        if (aSet.contains(cList.get(cList.size() - 1))) {
	            result = 1;  // A = [1, 5, 6, 9], B = 2, C = 99
	        }
	    }

	    // A = [0, 1, 2, 5]
	    // B = 3
	    // C = 101
	    // "101" has 3 digits, which equals with B.
	    boolean isFirst = true;
	    for (int digit : cList) {
	        int cnt = 0;
	        if (isFirst && B > 1) {
	        	int o = lower_bound(A,digit);
	        	if(A.get(0)==0){
	        		o--;
	        	}
	            cnt += o;
	            // print(o+"\n");
	        	// for (int d : A) {
          //       	cnt += (d > 0 && d < digit) ? 1 : 0;
          //   	}
	        } else {
	        	int o = lower_bound(A,digit);
	            cnt+=o ;
	            // print(o+"\n");
	            // for (int d : A) {
	            //     cnt += (d < digit) ? 1 : 0;
	            // }
	        }
	        isFirst = false;
	        result += cnt * (int)Math.pow(n, --B);
	        if (!aSet.contains(digit)) break;
	    }
	    return result;
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		print("Enter size:\n");
		int n = sc.nextInt();
		print("Enter digits for A:\n");
		ArrayList<Integer> A = new ArrayList<Integer>();
		for(int i = 0;i<n;i++){
			A.add(sc.nextInt());
		}
		print("Enter B:\n");
		int B = sc.nextInt();
		print("Enter C:\n");
		int C = sc.nextInt();
		print("Result: "+ solve(A,B,C)+"\n");

	}
}