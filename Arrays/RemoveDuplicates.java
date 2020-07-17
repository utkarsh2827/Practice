import java.util.*;
public class RemoveDuplicates{
	public static void print(String msg){
		System.out.print(msg);
	}
	public static int remove(int arr[]){
		int n = arr.length;
		int l = n;
		int i=1, j=0, curr=arr[0];
		while(i<n){
			if(curr!=arr[i]){
				j++;
				arr[j] = arr[i];
				curr = arr[i];
			}
			else{
				l--;
			}
			i++;
		}
		return l;
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
		int l = remove(arr);
		print("New Array:\n");
		for(int i = 0;i<l;i++){
			print(arr[i]+" ");
		}
		print("\n");
    }   
                             
}