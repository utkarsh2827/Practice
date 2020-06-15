class Node():
	def __init__(self,value):
		self.value = value
		self.right = None
		self.left = None
def build_tree(inOrder,postOrder,pIndex,inStart,inEnd,in_map):
	if inStart>inEnd or pIndex[0]==-1:
		return None
	node = Node(postOrder[pIndex[0]])
	pIndex[0] -= 1
	if inStart == inEnd:
		return node
	inIndex = in_map[node.value]
	node.right=build_tree(inOrder,postOrder,pIndex,inIndex+1,inEnd,in_map)
	node.left = build_tree(inOrder,postOrder,pIndex,inStart,inIndex-1,in_map)
	return node
def print_tree(node):
	if node == None:  
	    return
	print(node.value,end=" ") 
	print_tree(node.left)  
	print_tree(node.right)

n = int(input("Enter number of nodes in tree\n"))
inOrder = [int(x) for x in input('Enter Inorder:\n').split()]
postOrder = [int(x) for x in input('Enter Postorder:\n').split()]
in_map = {y:x for x,y in enumerate(inOrder)}
node = build_tree(inOrder,postOrder,[n-1],0,n-1,in_map)
print('PreOrder of The Resultant Tree:')
print_tree(node)
print()

#####################Time Complexity O(n)###########################


