def merge(arr,temp_arr,start,mid,end):
	i = start
	j = mid+1
	k = start
	inv_count = 0
	while i<=mid and j<=end:
		if arr[i]>arr[j]:
			inv_count+=(mid-i+1)
			temp_arr[k] = arr[j]
			j+=1
			k+=1
		else:
			temp_arr[k] = arr[i]
			i+=1
			k+=1
	while i <= mid: 
	    temp_arr[k] = arr[i] 
	    k += 1
	    i += 1
	while j <= end: 
	    temp_arr[k] = arr[j] 
	    k += 1
	    j += 1
	for o in range(start,end+1):
		arr[o] = temp_arr[o]

	return inv_count
def mergeSort(arr,n):
	temp_arr = [0]*n
	return _mergeSort(arr,temp_arr,0,n-1)
def _mergeSort(arr,temp_arr,start,end):
	inv_count = 0
	if start<end:
		mid = (start+end)//2
		inv_count += _mergeSort(arr,temp_arr,start,mid)
		inv_count +=  _mergeSort(arr,temp_arr,mid+1,end)
		inv_count +=  merge(arr,temp_arr,start,mid,end)
	return inv_count

n = int(input("Enter array size\n"))
arr = [int(x) for x in input("Enter the Array\n").split()]
print("Inversions in Array/Minimum no. of Adjacent swaps to sort: ",mergeSort(arr,n))
##############Can