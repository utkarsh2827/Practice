################Swaps need not be adjacent######################
################Graph Implementation######################

def get_swaps(arr,n):
	arr_pos = [*enumerate(arr)]
	arr_pos.sort(key = lambda x: x[1])
	# print(arr_pos)
	ans = 0
	visited = {k:False for k in range(n)}
	for i in range(n):
		if visited[i] or arr_pos[i][0] == i:
			continue
		cycle_size = 0
		j = i
		cycle = []
		while not visited[j]:
			# cycle.append(arr_pos[j])
			visited[j] = True
			j = arr_pos[j][0]
			cycle_size+=1
		if cycle_size>0 :
			ans += (cycle_size-1)
	return ans

n = int(input('Enter size of array\n'))
arr = [int(x) for x in input("Enter array elements\n").split()]
print("Minimum number of Swaps required are:",get_swaps(arr,n))
