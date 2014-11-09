import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;

class BinaryTree{
	public static void main(String[] args) {	
		TreeNode root = new TreeNode(5);
		root.val = 5;
		root.left.val = 3;
		root.right.val = 10;
		root.left.left.val = 20;
		root.left.right.val=21;
		root.right.left.val=1;
		System.out.println(countVisible(root)); 
	}
	
	// Validate a binary search tree
	public boolean BST(TreeNode root){
		return validateBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean validateBST(TreeNode root, int min, int max){
		if (root==null) {
			return true;
		}
		if (root.val<=min||root.val>=max) return false;
		return validateBST(root.right,root.val,max) && validateBST(root.left,min,root.val);
	}
	
	//print visible nodes of binary tree
	public static int countVisible(TreeNode root) {
		ArrayList<Integer> pre = new ArrayList<Integer>();
		if(root == null) return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count=1;
		stack.push(root);
		while(!stack.empty()){
			TreeNode current = stack.pop();
			pre.add(current.val);
			
			int maxSofar = current.val;
			if (current.left!=null) {
				if (current.left.val>=current.val) {
					stack.push(current.left);
					maxSofar = current.left.val;
					count++;
				}
				current = current.left;
			}
			
			if (current.right!=null) {
				if (current.right.val>= current.val) {
					stack.push(current.right);
					maxSofar = current.right.val;
					count++;
				}
				current = current.right;
			}
			
		}
		return count;
	}

	
	//4.2 given a directed graph, desiagn an algorithm to find out whether there is a route between two nodes.
	public enum state{
		unvisited,visited,visiting;
	}
	public static boolean search(Graph g, Node start, Node end){
		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u:g.getNodes()) {
			u.state = state.unvisited;
		}
		start.state = visiting;
		q.add(start);
		Node u;
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u!=null) {
				for (expressions) {
					
				}
			}
		}
	}
	
	//4.3 given a sorted array with unique integer elements, create a binary search tree with minimal height.
    TreeNode createMinimalBST(int arr[], int start, int end){
		if (start>end) {
			return null;
		}
		int mid = (start+end)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = creatMinimalBST(arr,start,mid-1);
		n.right = createMinimalBST(arr,mid+1,end);
		return n;	
	}
	TreeNode createMinimalBST(int array[]){
		return createMinimalBST(array,0,array.length-1);
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}