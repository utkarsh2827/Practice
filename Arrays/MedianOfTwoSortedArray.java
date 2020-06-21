import java.util.*;
public class MedianOfTwoSortedArray{
    public double findMedian(int a[], int b[]){
        if(a.length>b.length){
            return findMedian(b,a);
        }
        int x = a.length;
        int y = b.length;
        int low = 0;
        int high = x;
        while(low<=high){
            int partA = (low+high)/2;
            int partB = (x+y+1)/2-partA;

            int maxLeftA = (partA==0)?Integer.MIN_VALUE:a[partA-1];
            int minRightA = (partA==x)?Integer.MAX_VALUE:a[partA];

            int maxLeftB = (partB==0)?Integer.MIN_VALUE:b[partB-1];
            int minRightB = (partB==y)?Integer.MAX_VALUE:b[partB];

            if(maxLeftA<=minRightB && maxLeftB<=minRightA){
                if((x+y)%2==0){
                    return ((double)Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2;
                }
                else{
                    return (double)Math.max(maxLeftA,maxLeftB);
                }
            }
            else if(maxLeftA>minRightB){
                high = partA-1;
            }
            else{
                low = partA+1;
            }
        }
        return Double.MAX_VALUE;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter length of first array:");
        int x = sc.nextInt();
        System.out.println("Enter elements of first array:");
        int a[] = new int[x];
        for(int i = 0;i<x;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Enter length of second array:");
        int y = sc.nextInt();
        System.out.println("Enter elements of second array:");
        int b[] = new int[y];
        for(int i = 0;i<y;i++){
            b[i] = sc.nextInt();
        }
        
        MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();

        double ans = obj.findMedian(a,b);

        if(ans == Double.MAX_VALUE){
            System.out.println("ERROR: INPUT ARRAYS WEREN'T SORTED!!");
        }
        else{
            System.out.println("Median of two sorted arrays: " + ans);
        }
    }
}