import java.util.*;
public class TrieDs{
	static class Node{
		char ch;
		int wordEnd;
		Node children[];
		public Node(){
			ch = '\0';
			wordEnd = 0;
			children = new Node[26];
		}
		public Node(char ch){
			this.ch = ch;
			wordEnd = 0;
			children = new Node[26];
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
			int index = word.charAt(i)-'a';
			if(temp.children[index]==null){
				temp.children[index] = new Node(word.charAt(i));
				temp = temp.children[index];
			}
			else{
				temp = temp.children[index];
			}
			i++;
		}
		temp.wordEnd++;
	}
	public boolean search(String word){
		Node temp = root;
		int i = 0, n = word.length();
		while(i<n){
			int index = word.charAt(i)-'a';
			if(temp.children[index]==null){
				return false;
			}
			temp = temp.children[index];
			i++;
		}
		return temp.wordEnd!=0?true:false;
	}
	public static void print(String msg){
		System.out.print(msg);
	}
	public static void main(String args[]){
		TrieDs trie = new TrieDs();
		trie.insert("bla");
		trie.insert("blabla");
		trie.insert("fuckoff");
		print(trie.search("bla")+"\n");
		print(trie.search("bl")+"\n");
		print(trie.search("blabla")+"\n");
		print(trie.search("blab")+"\n");
		print(trie.search("fuckoff")+"\n");
		print(trie.search("fuck")+"\n");
		print(trie.search("ass")+"\n");

	}
}