#include <bits/stdc++.h>
using namespace std;
int main(){
	int n;
	cout<<"Enter length of array\n";
	cin>>n;
	int arr[n];
	cout<<"Enter elements:\n";
	for(int i = 0;i<n;i++){
		cin>>arr[i];
	}
	int count, sum = 0;
	for(int i=0;i<32;i++){
		count = 0;
		for(int j = 0;j<n;j++){
			if(arr[j]&(1<<i)){
				count+=1;
			}
		}
		sum += (count*(n-count)*2);
	}

	cout<<"Sum of Pairwise Hamming Distance is "<<sum<<"\n";
}