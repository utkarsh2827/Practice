#Without making a Tree
p_index = 0
def get_order(inOrder, postOrder, inStart, inEnd, l,in_map):
	global p_index
	if inStart>inEnd:
		return
	val = postOrder[p_index]
	inIndex = in_map[val]
	p_index-=1
	get_order(inOrder,postOrder,inIndex+1, inEnd, l,in_map )
	get_order(inOrder, postOrder,inStart,inIndex-1,l,in_map)
	l.append(val)
def preorder(inOrder, postOrder):
	l = []
	in_map = {y:x for x,y in enumerate(inOrder)}
	get_order(inOrder,postOrder,0,len(inOrder)-1,l,in_map)
	print(l[::-1])

n = int(input())
p_index = n-1
inOrder = [int(x) for x in input().split()]
postOrder = [int(x) for x in input().split()]
preorder(inOrder,postOrder)
