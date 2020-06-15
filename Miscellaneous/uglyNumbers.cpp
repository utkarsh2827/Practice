#include <bits/stdc++.h>
using namespace std;
long long int getNthUglyNumber(int n){
	long long int ugly[n];
	ugly[0] = 1;
	int i2 = 0, i3 = 0, i5 = 0;
	long long int next_2 = 2;
	long long int next_3 = 3;
	long long int next_5 = 5;
	long long int next;
	for(int i = 1; i<n; i++){
		next = min(next_2,min(next_3, next_5));
		ugly[i] = next;
		// cout<<next<<endl;
		if(next==next_2){
			i2 += 1;
			next_2 = ugly[i2]*2;
		}
		if(next == next_3){
			i3+=1;
			next_3 = ugly[i3]*3;
		}
		if(next==next_5){
			i5+=1;
			next_5 = ugly[i5]*5;
		}
	}	
	return next;
}
int main(){
	int n;
	cout<<"Enter n:\n";
	cin>>n;
	cout<<n<<"th Ugly Number is "<<getNthUglyNumber(n)<<endl;
}