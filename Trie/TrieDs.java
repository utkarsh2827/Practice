import java.util.*;
public class TrieDs{
	static class Node{
		char ch;
		int wordEnd;
		Node childs[];
		public Node(){
			ch = '';
			wordEnd = 0;
			childs = new Node[26];
		}
		public Node(char ch){
			this.ch = ch;
			wordEnd = 0;
			childs = new Node[26];
		}
	}

	Node root;

	public TrieDs(){
		root = new Node();
	}

	public void insert(String word){
		int n = word.length(), i = 0;
		Node temp = root;
		while(i<n){
			int index = word.charAt(i)-'a'
			if(temp.childs[index]==null){
				temp.childs[index] = new Node(word.charAt(i));
				temp = temp.childs[index];
			}
			else{
				temp = temp.childs[index];
			}
			i++;
		}
		temp.wordEnd++;
	}
	
}