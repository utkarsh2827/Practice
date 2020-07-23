import java.util.*;
public class LongestIncreasingSubsequence{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static int getLongestSubsequence(int arr[]){
		int T[] = new int[arr.length];
        int actualSolution[] = new int[arr.length];
        for(int i=0; i < arr.length; i++){
            T[i] = 1;
            actualSolution[i] = i;
        }
        
        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(T[j] + 1 > T[i]){
                        T[i] = T[j] + 1;
                        //set the actualSolution to point to guy before me
                        actualSolution[i] = j;
                    }
                }
            }
        }
        
        //find the index of max number in T 
        int maxIndex = 0;
        for(int i=0; i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }
        
        //lets print the actual solution
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = actualSolution[t];
        }while(t != newT);
        System.out.println();
 
        return T[maxIndex];
	}
    public static void main(String args[])
    {
    	Scanner sc = new Scanner(System.in);
    	print("Enter size:\n");
    	int n = sc.nextInt();
    	print("Enter elements:\n");
    	int arr[] = new int[n];
    	for(int i = 0;i<n;i++){
    		arr[i] = sc.nextInt();
    	}
    	print("Length of LIS: "+getLongestSubsequence(arr)+"\n");
    }   
                             
}