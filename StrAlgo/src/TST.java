public class TST {
	Node root;

	private class Node {
		char data;
		boolean isLastChar;
		Node left, equal, right;

		private Node(char d) {
			data = d;
			isLastChar = false;
			left = equal = right = null;
		}
	};

	public void insert(String word) {
		root = insert(root, word, 0);
	}

	private Node insert(Node curr, String word, int wordIndex) {
		if (curr == null)
			curr = new Node(word.charAt(wordIndex));
		if (word.charAt(wordIndex) < curr.data)
			curr.left = insert(curr.left, word, wordIndex);
		else if (word.charAt(wordIndex) > curr.data)
			curr.right = insert(curr.right, word, wordIndex);
		else {
			if (wordIndex < word.length() - 1)
				curr.equal = insert(curr.equal, word, wordIndex + 1);
			else
				curr.isLastChar = true;
		}
		return curr;
	}

	private boolean find(Node curr, String word, int wordIndex) {
		if (curr == null)
			return false;
		if (word.charAt(wordIndex) < curr.data)
			return find(curr.left, word, wordIndex);
		else if (word.charAt(wordIndex) > curr.data)
			return find(curr.right, word, wordIndex);
		else {
			if (wordIndex == word.length() - 1)
				return curr.isLastChar;
			return find(curr.equal, word, wordIndex + 1);
		}
	}

	public boolean find(String word) {
		boolean ret = find(root, word, 0);
		System.out.print(word + " :: ");
		if (ret)
			System.out.println(" Found ");
		else
			System.out.println("Not Found ");
		return ret;
	}

	public static void main(String[] args) {

		TST tt = new TST();
		tt.insert("banana");
		tt.insert("apple");
		tt.insert("mango");
		System.out.println("\nSearch results for apple, banana, grapes and mango :");
		tt.find("apple");
		tt.find("banana");
		tt.find("mango");
		tt.find("grapes");
	}
}