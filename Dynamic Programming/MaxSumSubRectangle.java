import java.util.*;
public class MaxSumSubRectangle{
	static class Result{
		int maxSum;
		int left;
		int right;
		int up;
		int down;
		public String toString(){
			return "Result [maxSum=" + maxSum + ", leftBound=" + left + ", rightBound=" + right + ", upBound=" + up+ ", lowBound=" + down + "]";
		}
	}
	static class Kadane{
		int start;
		int max;
		int end;
		Kadane(int m, int s, int e){
			start = s;
			end = e;
			max = m;
		}
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public static Kadane kadane(int arr[]){
		int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;
        for(int i=0; i < arr.length; i++){
            maxSoFar += arr[i];
            if(maxSoFar < 0){
                maxSoFar = 0;
                currentStart = i+1;
            }
            if(max < maxSoFar){
                maxStart = currentStart;
                maxEnd = i;
                max = maxSoFar;
            }
        }
        return new Kadane(max, maxStart, maxEnd);

	}
	public static Result getMaxSum(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int currRectHorizontalSum[] = new int[m];
		Result result = new Result();
		result.maxSum = Integer.MIN_VALUE;
		for(int l=0;l<n;l++){
			for(int i = 0;i<m;i++){
				currRectHorizontalSum[i] = 0;
			}
			for(int r = l;r<n;r++){
				for(int i = 0;i<m;i++){
					currRectHorizontalSum[i] += arr[i][r];
				}
				Kadane k = kadane(currRectHorizontalSum);
				if(k.max>result.maxSum){
					result.maxSum = k.max;
					result.up = k.start;
					result.down = k.end;
					result.left = l;
					result.right = r;
				}
			}
		}
		return result;
	} 
	public static void main(String args[]){
		int input[][] = {{ 2,  1, -3, -4,  5},
                         { 0,  6,  3,  4,  1},
                         { 2, -2, -1,  4, -5},
                         {-3,  3,  1,  0,  3}};
        print(getMaxSum(input).toString()+"\n");


	}
}