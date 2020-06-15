#include <bits/stdc++.h>
using namespace std;
long long int getNthBellNumber(int n){
	long long int bell[n][n];
	bell[0][0] = 1;
	for(int i = 1;i<n;i++){
		bell[i][0] = bell[i-1][i-1];
		for(int j=1;j<=i;j++){
			bell[i][j]= bell[i-1][j-1]+bell[i][j-1];
		}
	}
	// Uncomment to print the bell triangle
	// for(int i = 0;i<n;i++){
	// 	for(int j = 0;j<=i;j++){
	// 		cout<<bell[i][j]<<"\t";
	// 	}
	// 	cout<<"\n";
	// }
	return bell[n-1][n-1];
	
}
int main(){
	int n;
	cout<<"Enter n:\n";
	cin>>n;
	long long int x = getNthBellNumber(n);
	cout<<n<<"th Bell Number is "<<x<<endl;
}