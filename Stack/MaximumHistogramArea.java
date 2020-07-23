import java.util.*;
public class MaximumHistogramArea{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static int getMaximumArea(int heights[]){
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		int curr_area = 0;
		while(i<heights.length){
			if(stack.isEmpty() || heights[stack.peek()]<=heights[i]){
				stack.push(i++);
			}
			else{
				int index = stack.pop();
				if(stack.isEmpty()){
					curr_area = heights[index]*i;
				}
				else{
					curr_area = heights[index]*(i-stack.peek()-1);
				}
				max = Math.max(max,curr_area);
			}
		}
		while(!stack.isEmpty()){
			int index = stack.pop();
			if(stack.isEmpty()){
				curr_area = heights[index]*i;
			}
			else{
				curr_area = heights[index]*(i-stack.peek()-1);
			}
			max = Math.max(max,curr_area);
		}
		return max;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		print("Enter size:\n");
		int n = sc.nextInt();
		print("Enter elements:\n");
		int arr[] = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		print("Maximum Area: "+getMaximumArea(arr)+"\n");
	}
}