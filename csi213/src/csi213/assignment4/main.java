package csi213.assignment4;

public class main {

	public static void main(String[] args) {
		Trie trie = new Trie(4);
		trie.insert("cat");
		trie.exists("cat");
		trie.insert("cathedral");
	}

}
